package cn.gov.gzst.sso.server.utils.security;


import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
* Encodes and decodes to and from Base64 notation.
*
* <p>
* Change Log:
* </p>
* <ul>
*  <li>v2.1 - Cleaned up javadoc comments and unused variables and methods. Added
*   some convenience methods for reading and writing to and from files.</li>
*  <li>v2.0.2 - Now specifies UTF-8 encoding in places where the code fails on systems
*   with other encodings (like EBCDIC).</li>
*  <li>v2.0.1 - Fixed an error when decoding a single byte, that is, when the
*   encoded data was a single byte.</li>
*  <li>v2.0 - I got rid of methods that used booleans to set options.
*   Now everything is more consolidated and cleaner. The code now detects
*   when data that's being decoded is gzip-compressed and will decompress it
*   automatically. Generally things are cleaner. You'll probably have to
*   change some method calls that you were making to support the new
*   options format (<tt>int</tt>s that you "OR" together).</li>
*  <li>v1.5.1 - Fixed bug when decompressing and decoding to a
*   byte[] using <tt>decode( String s, boolean gzipCompressed )</tt>.
*   Added the ability to "suspend" encoding in the Output Stream so
*   you can turn on and off the encoding if you need to embed base64
*   data in an otherwise "normal" stream (like an XML file).</li>
*  <li>v1.5 - Output stream pases on flush() command but doesn't do anything itself.
*      This helps when using GZIP streams.
*      Added the ability to GZip-compress objects before encoding them.</li>
*  <li>v1.4 - Added helper methods to read/write files.</li>
*  <li>v1.3.6 - Fixed OutputStream.flush() so that 'position' is reset.</li>
*  <li>v1.3.5 - Added flag to turn on and off line breaks. Fixed bug in input stream
*      where last buffer being read, if not completely full, was not returned.</li>
*  <li>v1.3.4 - Fixed when "improperly padded stream" error was thrown at the wrong time.</li>
*  <li>v1.3.3 - Fixed I/O streams which were totally messed up.</li>
* </ul>
*
* <p>
* I am placing this code in the Public Domain. Do with it as you will.
* This software comes with no guarantees or warranties but with
* plenty of well-wishing instead!
* Please visit <a href="http://iharder.net/base64">http://iharder.net/base64</a>
* periodically to check for updates or to contribute improvements.
* </p>
*
* @author Robert Harder
* @author rob@iharder.net
* @version 2.1
*/
public class Base64
{

	public final static int NO_OPTIONS = 0;

	public final static int GZIP = 2;

	public final static int DONT_GUNZIP = 4;

	public final static int ENCODE = 1;

	public final static int DO_BREAK_LINES = 8;

	private final static int MAX_LINE_LENGTH = 76;

	public final static int URL_SAFE = 16;

	public final static int ORDERED = 32;

	private final static byte WHITE_SPACE_ENC = -5;

	private final static byte EQUALS_SIGN_ENC = -1;

	private final static String PREFERRED_ENCODING = "UTF-8";

	private final static byte NEW_LINE = (byte)'\n';

	private final static byte EQUALS_SIGN = (byte)'=';

    private final static byte[] _STANDARD_ALPHABET = {
        (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G',
        (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N',
        (byte)'O', (byte)'P', (byte)'Q', (byte)'R', (byte)'S', (byte)'T', (byte)'U', 
        (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
        (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g',
        (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n',
        (byte)'o', (byte)'p', (byte)'q', (byte)'r', (byte)'s', (byte)'t', (byte)'u', 
        (byte)'v', (byte)'w', (byte)'x', (byte)'y', (byte)'z',
        (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', 
        (byte)'6', (byte)'7', (byte)'8', (byte)'9', (byte)'+', (byte)'/'
    };

    private final static byte[] _URL_SAFE_ALPHABET = {
        (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G',
        (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N',
        (byte)'O', (byte)'P', (byte)'Q', (byte)'R', (byte)'S', (byte)'T', (byte)'U', 
        (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
        (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g',
        (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n',
        (byte)'o', (byte)'p', (byte)'q', (byte)'r', (byte)'s', (byte)'t', (byte)'u', 
        (byte)'v', (byte)'w', (byte)'x', (byte)'y', (byte)'z',
        (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', 
        (byte)'6', (byte)'7', (byte)'8', (byte)'9', (byte)'-', (byte)'_'
    };

    private final static byte[] _ORDERED_ALPHABET = {
        (byte)'-',
        (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4',
        (byte)'5', (byte)'6', (byte)'7', (byte)'8', (byte)'9',
        (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G',
        (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N',
        (byte)'O', (byte)'P', (byte)'Q', (byte)'R', (byte)'S', (byte)'T', (byte)'U',
        (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
        (byte)'_',
        (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g',
        (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n',
        (byte)'o', (byte)'p', (byte)'q', (byte)'r', (byte)'s', (byte)'t', (byte)'u',
        (byte)'v', (byte)'w', (byte)'x', (byte)'y', (byte)'z'
    };

    private final static byte[] _URL_SAFE_DECODABET = {
        -9,-9,-9,-9,-9,-9,-9,-9,-9,                 // Decimal  0 -  8
        -5,-5,                                      // Whitespace: Tab and Linefeed
        -9,-9,                                      // Decimal 11 - 12
        -5,                                         // Whitespace: Carriage Return
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 14 - 26
        -9,-9,-9,-9,-9,                             // Decimal 27 - 31
        -5,                                         // Whitespace: Space
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,              // Decimal 33 - 42
        -9,                                         // Plus sign at decimal 43
        -9,                                         // Decimal 44
        62,                                         // Minus sign at decimal 45
        -9,                                         // Decimal 46
        -9,                                         // Slash at decimal 47
        52,53,54,55,56,57,58,59,60,61,              // Numbers zero through nine
        -9,-9,-9,                                   // Decimal 58 - 60
        -1,                                         // Equals sign at decimal 61
        -9,-9,-9,                                   // Decimal 62 - 64
        0,1,2,3,4,5,6,7,8,9,10,11,12,13,            // Letters 'A' through 'N'
        14,15,16,17,18,19,20,21,22,23,24,25,        // Letters 'O' through 'Z'
        -9,-9,-9,-9,                                // Decimal 91 - 94
        63,                                         // Underscore at decimal 95
        -9,                                         // Decimal 96
        26,27,28,29,30,31,32,33,34,35,36,37,38,     // Letters 'a' through 'm'
        39,40,41,42,43,44,45,46,47,48,49,50,51,     // Letters 'n' through 'z'
        -9,-9,-9,-9,-9                              // Decimal 123 - 127
        ,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,       // Decimal 128 - 139
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 140 - 152
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 153 - 165
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 166 - 178
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 179 - 191
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 192 - 204
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 205 - 217
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 218 - 230
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 231 - 243
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9         // Decimal 244 - 255 
    };

    private final static byte[] _ORDERED_DECODABET = {
        -9,-9,-9,-9,-9,-9,-9,-9,-9,                 // Decimal  0 -  8
        -5,-5,                                      // Whitespace: Tab and Linefeed
        -9,-9,                                      // Decimal 11 - 12
        -5,                                         // Whitespace: Carriage Return
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 14 - 26
        -9,-9,-9,-9,-9,                             // Decimal 27 - 31
        -5,                                         // Whitespace: Space
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,              // Decimal 33 - 42
        -9,                                         // Plus sign at decimal 43
        -9,                                         // Decimal 44
        0,                                          // Minus sign at decimal 45
        -9,                                         // Decimal 46
        -9,                                         // Slash at decimal 47
        1,2,3,4,5,6,7,8,9,10,                       // Numbers zero through nine
        -9,-9,-9,                                   // Decimal 58 - 60
        -1,                                         // Equals sign at decimal 61
        -9,-9,-9,                                   // Decimal 62 - 64
        11,12,13,14,15,16,17,18,19,20,21,22,23,     // Letters 'A' through 'M'
        24,25,26,27,28,29,30,31,32,33,34,35,36,     // Letters 'N' through 'Z'
        -9,-9,-9,-9,                                // Decimal 91 - 94
        37,                                         // Underscore at decimal 95
        -9,                                         // Decimal 96
        38,39,40,41,42,43,44,45,46,47,48,49,50,     // Letters 'a' through 'm'
        51,52,53,54,55,56,57,58,59,60,61,62,63,     // Letters 'n' through 'z'
        -9,-9,-9,-9,-9                              // Decimal 123 - 127
        ,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,    // Decimal 128 - 139
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 140 - 152
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 153 - 165
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 166 - 178
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 179 - 191
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 192 - 204
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 205 - 217
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 218 - 230
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 231 - 243
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9         // Decimal 244 - 255 
    };

    private final static byte[] _STANDARD_DECODABET = {
        -9,-9,-9,-9,-9,-9,-9,-9,-9,                 // Decimal  0 -  8
        -5,-5,                                      // Whitespace: Tab and Linefeed
        -9,-9,                                      // Decimal 11 - 12
        -5,                                         // Whitespace: Carriage Return
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 14 - 26
        -9,-9,-9,-9,-9,                             // Decimal 27 - 31
        -5,                                         // Whitespace: Space
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,              // Decimal 33 - 42
        62,                                         // Plus sign at decimal 43
        -9,-9,-9,                                   // Decimal 44 - 46
        63,                                         // Slash at decimal 47
        52,53,54,55,56,57,58,59,60,61,              // Numbers zero through nine
        -9,-9,-9,                                   // Decimal 58 - 60
        -1,                                         // Equals sign at decimal 61
        -9,-9,-9,                                   // Decimal 62 - 64
        0,1,2,3,4,5,6,7,8,9,10,11,12,13,            // Letters 'A' through 'N'
        14,15,16,17,18,19,20,21,22,23,24,25,        // Letters 'O' through 'Z'
        -9,-9,-9,-9,-9,-9,                          // Decimal 91 - 96
        26,27,28,29,30,31,32,33,34,35,36,37,38,     // Letters 'a' through 'm'
        39,40,41,42,43,44,45,46,47,48,49,50,51,     // Letters 'n' through 'z'
        -9,-9,-9,-9,-9                              // Decimal 123 - 127
        ,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,       // Decimal 128 - 139
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 140 - 152
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 153 - 165
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 166 - 178
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 179 - 191
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 192 - 204
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 205 - 217
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 218 - 230
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,     // Decimal 231 - 243
        -9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9         // Decimal 244 - 255 
    };

	public static String encode(byte[] source) {
		String encoded = null;
		try {
			encoded = encodeBytes(source, 0, source.length, NO_OPTIONS);
		} catch (IOException ex) {
			assert false : ex.getMessage();
		}
		assert encoded != null;
		return encoded;
	}

	public static String encodeBytes(byte[] source, int off, int len, int options) throws IOException {
		byte[] encoded = encodeBytesToBytes(source, off, len, options);
		try {
			return new String(encoded, PREFERRED_ENCODING);
		} catch (UnsupportedEncodingException uue) {
			return new String(encoded);
		}
	}

	public static byte[] encodeBytesToBytes( byte[] source, int off, int len, int options ) throws IOException {
		if (source == null) {
			throw new NullPointerException("Cannot serialize a null array.");
		}

		if (off < 0) {
			throw new IllegalArgumentException("Cannot have negative offset: " + off);
		}

		if (len < 0) {
			throw new IllegalArgumentException("Cannot have length offset: " + len);
		}

		if (off + len > source.length) {
			throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", off, len, source.length));
		}

		if ((options & GZIP) != 0) {
			ByteArrayOutputStream baos = null;
			GZIPOutputStream gzos = null;
			OutputStream b64os = null;

			try {
				baos = new ByteArrayOutputStream();
				b64os = new OutputStream(baos, ENCODE | options);
				gzos = new GZIPOutputStream(b64os);

				gzos.write(source, off, len);
				gzos.close();
			} catch (IOException e) {
				throw e;
			} finally {
				try {
					gzos.close();
				} catch (Exception e) {
				}
				try {
					b64os.close();
				} catch (Exception e) {
				}
				try {
					baos.close();
				} catch (Exception e) {
				}
			}

			return baos.toByteArray();
		} else {
			boolean breakLines = (options & DO_BREAK_LINES) != 0;

			int encLen = (len / 3) * 4 + (len % 3 > 0 ? 4 : 0);
			if (breakLines) {
				encLen += encLen / MAX_LINE_LENGTH;
			}
			byte[] outBuff = new byte[encLen];

			int d = 0;
			int e = 0;
			int len2 = len - 2;
			int lineLength = 0;
			for (; d < len2; d += 3, e += 4) {
				encode3to4(source, d + off, 3, outBuff, e, options);

				lineLength += 4;
				if (breakLines && lineLength >= MAX_LINE_LENGTH) {
					outBuff[e + 4] = NEW_LINE;
					e++;
					lineLength = 0;
				}
			}

			if (d < len) {
				encode3to4(source, d + off, len - d, outBuff, e, options);
				e += 4;
			}

			if (e <= outBuff.length - 1) {
				byte[] finalOut = new byte[e];
				System.arraycopy(outBuff, 0, finalOut, 0, e);
				return finalOut;
			} else {
				return outBuff;
			}
		}
	}

	public static byte[] decode(String s) throws IOException {
		return decode(s, NO_OPTIONS);
	}

	public static byte[] decode(String s, int options) throws IOException {
		if (s == null) {
			throw new NullPointerException("Input string was null.");
		}

		byte[] bytes;
		try {
			bytes = s.getBytes(PREFERRED_ENCODING);
		} catch (UnsupportedEncodingException uee) {
			bytes = s.getBytes();
		}

		bytes = decode(bytes, 0, bytes.length, options);

		boolean dontGunzip = (options & DONT_GUNZIP) != 0;
		if ((bytes != null) && (bytes.length >= 4) && (!dontGunzip)) {
			int head = ((int) bytes[0] & 0xff) | ((bytes[1] << 8) & 0xff00);
			if (GZIPInputStream.GZIP_MAGIC == head) {
				ByteArrayInputStream bais = null;
				GZIPInputStream gzis = null;
				ByteArrayOutputStream baos = null;
				byte[] buffer = new byte[2048];
				int length = 0;

				try {
					baos = new ByteArrayOutputStream();
					bais = new ByteArrayInputStream(bytes);
					gzis = new GZIPInputStream(bais);

					while ((length = gzis.read(buffer)) >= 0) {
						baos.write(buffer, 0, length);
					}

					bytes = baos.toByteArray();

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						baos.close();
					} catch (Exception e) {
					}
					try {
						gzis.close();
					} catch (Exception e) {
					}
					try {
						bais.close();
					} catch (Exception e) {
					}
				}

			}
		}

		return bytes;
	}

	public static byte[] decode(byte[] source, int off, int len, int options) throws IOException {

		if (source == null) {
			throw new NullPointerException("Cannot decode null source array.");
		} 
		if (off < 0 || off + len > source.length) {
			throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", source.length, off, len));
		}

		if (len == 0) {
			return new byte[0];
		} else if (len < 4) {
			throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + len);
		} 

		byte[] DECODABET = getDecodabet(options);

		int len34 = len * 3 / 4;
		byte[] outBuff = new byte[len34];
		int outBuffPosn = 0;

		byte[] b4 = new byte[4];

		int b4Posn = 0;
		int i = 0;
		byte sbiDecode = 0;

		for (i = off; i < off + len; i++) {

			sbiDecode = DECODABET[source[i] & 0xFF];

			if (sbiDecode >= WHITE_SPACE_ENC) {
				if (sbiDecode >= EQUALS_SIGN_ENC) {
					b4[b4Posn++] = source[i];
					if (b4Posn > 3) {
						outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn, options);
						b4Posn = 0;

						if (source[i] == EQUALS_SIGN) {
							break;
						}
					}
				}
			} else {
				throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", ((int) source[i]) & 0xFF, i));
			}
		}

		byte[] out = new byte[outBuffPosn];
		System.arraycopy(outBuff, 0, out, 0, outBuffPosn);
		return out;
	}

	private static byte[] encode3to4(byte[] source, int srcOffset, int numSigBytes, byte[] destination, int destOffset, int options) {

		byte[] ALPHABET = getAlphabet(options);

		int inBuff = (numSigBytes > 0 ? ((source[srcOffset] << 24) >>> 8) : 0)
				| (numSigBytes > 1 ? ((source[srcOffset + 1] << 24) >>> 16) : 0)
				| (numSigBytes > 2 ? ((source[srcOffset + 2] << 24) >>> 24) : 0);

		switch (numSigBytes) {
		case 3:
			destination[destOffset] = ALPHABET[(inBuff >>> 18)];
			destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 0x3f];
			destination[destOffset + 2] = ALPHABET[(inBuff >>> 6) & 0x3f];
			destination[destOffset + 3] = ALPHABET[(inBuff) & 0x3f];
			return destination;
		case 2:
			destination[destOffset] = ALPHABET[(inBuff >>> 18)];
			destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 0x3f];
			destination[destOffset + 2] = ALPHABET[(inBuff >>> 6) & 0x3f];
			destination[destOffset + 3] = EQUALS_SIGN;
			return destination;
		case 1:
			destination[destOffset] = ALPHABET[(inBuff >>> 18)];
			destination[destOffset + 1] = ALPHABET[(inBuff >>> 12) & 0x3f];
			destination[destOffset + 2] = EQUALS_SIGN;
			destination[destOffset + 3] = EQUALS_SIGN;
			return destination;
		default:
			return destination;
		}
	}

	private static int decode4to3(byte[] source, int srcOffset, byte[] destination, int destOffset, int options) {

		if (source == null) {
			throw new NullPointerException("Source array was null.");
		}
		if (destination == null) {
			throw new NullPointerException("Destination array was null.");
		}
		if (srcOffset < 0 || srcOffset + 3 >= source.length) {
			throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", source.length, srcOffset));
		}
		if (destOffset < 0 || destOffset + 2 >= destination.length) {
			throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", destination.length, destOffset));
		}

		byte[] DECODABET = getDecodabet(options);

		if (source[srcOffset + 2] == EQUALS_SIGN) {
			int outBuff = ((DECODABET[source[srcOffset]] & 0xFF) << 18) | ((DECODABET[source[srcOffset + 1]] & 0xFF) << 12);

			destination[destOffset] = (byte) (outBuff >>> 16);
			return 1;
		} else if (source[srcOffset + 3] == EQUALS_SIGN) {
			int outBuff = ((DECODABET[source[srcOffset]] & 0xFF) << 18)
					| ((DECODABET[source[srcOffset + 1]] & 0xFF) << 12)
					| ((DECODABET[source[srcOffset + 2]] & 0xFF) << 6);

			destination[destOffset] = (byte) (outBuff >>> 16);
			destination[destOffset + 1] = (byte) (outBuff >>> 8);
			return 2;
		} else {
			int outBuff = ((DECODABET[source[srcOffset]] & 0xFF) << 18)
					| ((DECODABET[source[srcOffset + 1]] & 0xFF) << 12)
					| ((DECODABET[source[srcOffset + 2]] & 0xFF) << 6)
					| ((DECODABET[source[srcOffset + 3]] & 0xFF));

			destination[destOffset] = (byte) (outBuff >> 16);
			destination[destOffset + 1] = (byte) (outBuff >> 8);
			destination[destOffset + 2] = (byte) (outBuff);

			return 3;
		}
	}

	private final static byte[] getAlphabet(int options) {
		if ((options & URL_SAFE) == URL_SAFE) {
			return _URL_SAFE_ALPHABET;
		} else if ((options & ORDERED) == ORDERED) {
			return _ORDERED_ALPHABET;
		} else {
			return _STANDARD_ALPHABET;
		}
	}

	private final static byte[] getDecodabet(int options) {
		if ((options & URL_SAFE) == URL_SAFE) {
			return _URL_SAFE_DECODABET;
		} else if ((options & ORDERED) == ORDERED) {
			return _ORDERED_DECODABET;
		} else {
			return _STANDARD_DECODABET;
		}
	}

	public static class OutputStream extends FilterOutputStream {

		private boolean encode;
        private int     position;
        private byte[]  buffer;
        private int     bufferLength;
        private int     lineLength;
        private boolean breakLines;
        private byte[]  b4;
        private boolean suspendEncoding;
        private int     options;
        private byte[]  decodabet;

		public OutputStream(java.io.OutputStream out) {
			this(out, ENCODE);
		}

		public OutputStream(java.io.OutputStream out, int options) {
			super(out);
			this.breakLines = (options & DO_BREAK_LINES) != 0;
			this.encode = (options & ENCODE) != 0;
			this.bufferLength = encode ? 3 : 4;
			this.buffer = new byte[bufferLength];
			this.position = 0;
			this.lineLength = 0;
			this.suspendEncoding = false;
			this.b4 = new byte[4];
			this.options = options;
			this.decodabet = getDecodabet(options);
		}
	}

}
