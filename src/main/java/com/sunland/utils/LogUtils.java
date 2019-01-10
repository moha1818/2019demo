package com.sunland.utils;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * Created by batwings on 15/12/31.
 */
public class LogUtils {

    public final static String LOGMODULE_SERVICE = "1";//代理接口日志 1
    public final static String LOGMODULE_BACKGROUND = "2";//后台服务 2
    public final static String LOGTYPE_USUAL = "0001"; //日志类型 普通类型
    public final static String OPERATETYPE_ADD = "1";//操作方法 新增
    public final static String OPERATETYPE_UPDATE = "2";//操作方法 更新
    public final static String OPERATETYPE_DELETE = "3";//操作方法 删除
    public final static String OPERATETYPE_QUERY = "4";//操作方法 查询
    public final static String OPERATETYPE_OTHER = "9";//操作方法 其他
    public final static String EXECSTATUS_SUCCESS = "1";//执行状态 成功
    public final static String EXECSTATUS_ERROR = "2";//执行状态 失败
    public final static String RETURNFLAG_OK = "0";//返回标识  成功
    public final static String RETURNFLAG_ERROR = "1";//返回标识  失败

    private String yhdm;//用户名
    //	private String bmdm;//部门代码
    private String pdaid;//终端号
    private String simid;//SIM卡号
    private String logmodule;//日志模块（1-代理接口；2-后台管理）
    private String logtype;//日志种类
    private String operatetype;//操作类型（1-新增 2-修改 3-删除 4-查询 9-其它）
    private String methodname;//方法名
    private String methodinfo;//接口传入内容（不包含照片数据）
    private String execstatus;//执行状态(1:成功 2:失败)
    private String execerrorinfo;//错误信息
    private Long alltimespent;//接口调用所用时间
    private Long proxytimespent;//数据代理端接口所用时间
    //	private String logcontent;//日志内容
    private Date logtime;//日志时间
    //	private String memo;//备注
    private String returnflag;//返回标识（正常:0 异常:1）
    private String returninfo;//返回信息
    //	private String gpsx;//经度
    // 	private String gpsy;//纬度
    private Date beginTime;//日志产生时间
    private Date endTime;//日志结束时间
    private Date proxyBeginTime;
    private Date proxyEndTime;

    public LogUtils(String yhdm, String pdaid, String simid, String logmodule, String logtype, String operatetype, String methodname) {
        this.yhdm = yhdm;
        this.pdaid = pdaid;
        this.logmodule = logmodule;
        this.logtype = logtype;
        this.operatetype = operatetype;
        this.methodname = methodname;
        this.simid = simid;
        beginTime = new Date();
        logtime = new Date();
    }

    public LogUtils(int userId, String pdaid, String simid, String logmodule, String logtype, String operatetype, String methodname) {
        this.yhdm = String.valueOf(userId);
        this.pdaid = pdaid;
        this.logmodule = logmodule;
        this.logtype = logtype;
        this.operatetype = operatetype;
        this.methodname = methodname;
        this.simid = simid;
        beginTime = new Date();
        logtime = new Date();
    }

    public void setParam(String param, Object... objects) {
        if (!StringUtils.isEmpty(param)) {
            String[] pararr = param.split(",");
            JSONObject jsonObject = new JSONObject();
            for (int i = 0, length = pararr.length; i < length; i++) {
                jsonObject.put(pararr[i], objects[i]);
            }
            methodinfo = jsonObject.toString();
        }
    }

//    public PdaLog successLog(String returninfo) {
//        this.execstatus = EXECSTATUS_SUCCESS;
//        this.returnflag = RETURNFLAG_OK;
//        this.returninfo = returninfo;
//        this.endTime = new Date();
//        this.alltimespent = endTime.getTime() - beginTime.getTime();
//
//        PdaLog pdaLog = new PdaLog();
//        pdaLog.setYhdm(yhdm);
//        pdaLog.setPdaid(pdaid);
//        pdaLog.setSimid(simid);
//        pdaLog.setLogmodule(logmodule);
//        pdaLog.setLogtype(logtype);
//        pdaLog.setOperatetype(operatetype);
//        pdaLog.setMethodname(methodname);
//        pdaLog.setMethodinfo(methodinfo);
//        pdaLog.setExecstatus(this.execstatus);
//        pdaLog.setExecerrorinfo(this.execerrorinfo);
//        pdaLog.setAlltimespent(alltimespent);
//        pdaLog.setLogtime(logtime);
//        pdaLog.setReturnflag(this.returnflag);
//        pdaLog.setReturninfo(this.returninfo);
//        pdaLog.setProxytimespent(proxytimespent);
//        return pdaLog;
//    }
//
//    public PdaLog errorLog(String returnflag, String returninfo, String execerrorinfo) {
//        this.execstatus = EXECSTATUS_ERROR;
//        this.returnflag = returnflag;
//        this.returninfo = returninfo;
//        this.execerrorinfo = execerrorinfo;
//        endTime = new Date();
//        alltimespent = endTime.getTime() - beginTime.getTime();
//
//        PdaLog pdaLog = new PdaLog();
//        pdaLog.setYhdm(yhdm);
//        pdaLog.setPdaid(pdaid);
//        pdaLog.setSimid(simid);
//        pdaLog.setLogmodule(logmodule);
//        pdaLog.setLogtype(logtype);
//        pdaLog.setOperatetype(operatetype);
//        pdaLog.setMethodname(methodname);
//        pdaLog.setMethodinfo(methodinfo);
//        pdaLog.setExecstatus(this.execstatus);
//        pdaLog.setExecerrorinfo(this.execerrorinfo);
//        pdaLog.setAlltimespent(alltimespent);
//        pdaLog.setLogtime(logtime);
//        pdaLog.setReturnflag(this.returnflag);
//        pdaLog.setReturninfo(this.returninfo);
//        pdaLog.setProxytimespent(proxytimespent);
//        return pdaLog;
//    }

    public void startProxy() {
        proxyBeginTime = new Date();
    }

    public void endProxy() {
        proxyEndTime = new Date();
        try {
            proxytimespent = proxyEndTime.getTime() - proxyBeginTime.getTime();
        } catch (Exception e) {
        }
    }
}
