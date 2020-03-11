package cn.gov.gzst.assessment.common.bean;

/**
 * Created by Administrator on 2019/4/8.
 */
public enum Status {
    NOTCHECK("未审核",0), PASS("通过",1), ISBACK("已退回",-1);
    private String name;
    private int index;
    private Status(String name,int index){
        this.name = name;
        this.index=index;

    }
    @Override
    public String toString(){
        return this.index+"-"+this.name;
    }
    public int getValue(){
        return this.index;
    }
    public String setName( String name){
        return this.name = name;
    }



}
