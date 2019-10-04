package com.zjhs.hstx.base;

/**
 * 全局常量
 */
public class CommonConstants {

    public static final String BASE_URL = "";

    /**
     * 每个服务对应的服务名称
     */
    public static class SERVER {
        public static final String BASE = "hstx";
    }

    public static class DELETE_CODE {
        /**
         * 数据未删除状态
         */
        public static final Integer DEL_FLAG_NORMAL = 0;

        /**
         * 数据已删除状态
         */
        public static final Integer DEL_FLAG_DELETE = 1;
    }

    /**
     * 登录信息
     */
    public static class LOGIN_INFO {
        /**
         * 登录请求来自电脑端
         */
        public static final String LOGIN_FROM_PC = "0";
        /**
         * 登录来源来自app端
         */
        public static final String LOGIN_FROM_APP = "1";

        /**
         * 默认电脑端token过期时间,单位毫秒  36小时
         */
        public static final Long DEFAULT_PC_TOKEN_INVALID_TIME = 36 * 60 * 60 * 1000L;

        /**
         * 默认手机端token过期时间,单位毫秒  7天
         */
        public static final Long DEFAULT_APP_TOKEN_INVALID_TIME = 1000 * 60 * 60 * 24 * 7L;
    }

    /**
     * 请求信息
     */
    public static class REQUEST_INFO {
        /**
         * 请求ID前缀
         */
        public static final String REQUEST_ID_PREFIX = "REQUEST_ID:";

        /**
         * 默认的请求间隔时间，防止重复提交 1秒
         */
        public static final Long DEFAULT_REQUEST_INTERVAL_TIME = 1000L;
    }

    /**
     * 分页信息
     */
    public static class PAGE_INFO {
        /**
         * 分页标志
         */
        public static final String PAGE = "page";

        /**
         * 默认的分页大小
         */
        public static final int DEFAULT_PAGESIZE = 20;

        /**
         * 默认的第几页
         */
        public static final int DEFAULT_PAGE = 1;
    }

    public static class SYS_USER {
        /**
         * 是否是超级用户，0不是
         */
        public static final String IS_NOT_ADMIN = "0";
        /**
         * 是否是超级用户，1是
         */
        public static final String IS__ADMIN = "1";

    }


    /**
     * 返回结果
     */
    public static class RETURN_RESULT {
        /**
         * 结果处理成功
         */
        public static final String RESULT_SUCCESS = "00";
        /**
         * 登录失败
         */
        public static final String RESULT_LOGIN_FAILD = "01";
        /**
         * 操作失败，统一返回代码编号，直接打印出msg信息
         */
        public static final String RESULT_OPERATION_FAILED = "99";

        /**
         * 重复提交，直接打印出msg信息
         */
        public static final String RESULT_REPEAT_SUBMIT = "90";

        /**
         * feign的hystrix超时
         */
        public static final String HYSTRIX_TIME_OUT = "88";
        /**
         * token验证失败,提示非法操作
         */
        public static final String RESULT_TOKEN_INVALID = "100";
        /**
         * token过期，引导到登录界面
         */
        public static final String RESULT_TOKEN_EXPIRED = "101";
    }


    /**
     * 极光推送秘钥信息
     */
    public static class J_PUSH_KEY {
        public static final String HSTX_KEY = "hstxKey";
        public static final String HSTX_SECRET = "hstxSecret";
    }
}