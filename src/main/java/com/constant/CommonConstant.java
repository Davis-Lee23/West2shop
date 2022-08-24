package com.constant;

/**
 * @Description: TODO 通用常量
 * @author: LZP
 * @date: 2022年08月17日 16:50
 */
public class CommonConstant {
    /**
     * 状态码-200
     */
    public static final Integer SC_OK_200 = 200;
    /**
     * 状态码-500
     */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * 删除标志-未删除
     */
    public static final Integer DEL_FLAG_0 = 0;
    /**
     * 删除标志-已删除
     */
    public static final Integer DEL_FLAG_1 = 1;
    /**
     * 祖宗节点
     */
    public static final String TYPES_ANCESTOR = "0";

    /**
     * 商品编号前缀
     */
    public static final String GOOD_NO = "SP";

    /**
     * 入库编号前缀
     */
    public static final String IN_ORDER_NO = "RK";

    /**
     * 出库编号前缀
     */
    public static final String OUT_NO = "CK";

    /**
     * 提示常量-新增成功
     */
    public static final String ADD_SUCCESS = "新增成功";

    /**
     * 提示常量-编辑成功
     */
    public static final String EDIT_SUCCESS = "编辑成功";

    /**
     * 提示常量-新增成功
     */
    public static final String DELETE_SUCCESS = "删除成功";
}
