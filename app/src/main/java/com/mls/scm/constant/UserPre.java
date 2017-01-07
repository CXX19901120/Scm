package com.mls.scm.constant;


import com.mls.scm.application.AppContext;
import com.mls.scm.http.RetrofitManager;
import com.orhanobut.logger.Logger;

/**
 * Created by CXX on 2015/11/13.
 */
public class UserPre {
    public static void saveUserId(String id) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_ID, id);
    }

    public static String getUserId() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_ID, "");
    }

    public static void saveUserName(String userName) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_NAME, userName);
    }

    public static String getUserName() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_NAME, "");
    }

    /**
     * 报存用户头像
     * @param logo
     */
    public static void saveUserLogo(String logo) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_LOGO, logo);
    }

    /**
     *获取用户头像
     * @return
     */
    public static String getUserLogo() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_LOGO, "");
    }
    public static void saveCommpanyName(String name) {
        AppContext.getPreUtils().put(PrefConst.PRECOMPANYNAME, name);
    }

    public static String getCommpanyName() {
        return AppContext.getPreUtils().getString(PrefConst.PRECOMPANYNAME, "");
    }

    public static String getToken() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_TOKEN, "");

    }
    public static void setToken(String token) {
         AppContext.getPreUtils().put(PrefConst.PRE_USER_TOKEN, token);

    }



    /**
     * 保存用户性别*/
    public static void setGender(String gender){
        AppContext.getPreUtils().put(PrefConst.PRE_USER_GENDER,gender);
    }

    /**
     * 获取用户性别*/
    public static String getGender(){
       return AppContext.getPreUtils().getString(PrefConst.PRE_USER_GENDER,"");
    }

    /**
     * 保存用户挪车电话*/
    public static void setPhoneCall(String phoneCall){
        AppContext.getPreUtils().put(PrefConst.PHONE_CALL,phoneCall);
    }

    /**
     * 获取用户挪车电话*/
    public static String getPhoneCall(){
        return AppContext.getPreUtils().getString(PrefConst.PHONE_CALL,UserPre.getUserName());
    }


    /**
     * 保存用户昵称*/

    public static void setNickName(String nickName){
        AppContext.getPreUtils().put(PrefConst.PRE_NICKNAME,nickName);
    }
    /**
     * 获取用户昵称*/
    public static String getNickName(){
        return AppContext.getPreUtils().getString(PrefConst.PRE_NICKNAME,"");
    }


    /**
     * 保存用户状态
     * @param status 用户状态
     */
    public static void setUserStatus(String status) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_STATUS, status);
    }

    /**
     * 获取用户状态
     * @return
     */
    public static String getUserStatus() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_STATUS, "");
    }


    public static void setCarIsAuth(boolean isAuth) {
        AppContext.getPreUtils().put(PrefConst.PRE_CAR_AUTH, isAuth);
    }

    public static boolean getCarIsAuth() {
        return AppContext.getPreUtils().getBoolean(PrefConst.PRE_CAR_AUTH, false);
    }

    /**
     * 保存会员认证的实体类
     * @param auth
     */
    public static void saveAuthBean(String auth) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_AUTH, auth);
    }

    /**
     * 获取会员认证的实体类
     * @return
     */
    public static String getAuthBean() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_AUTH, "");
    }

    /**
     * 保存银行卡
     * @param blance
     */
    public static void saveBlance(String blance) {
        AppContext.getPreUtils().put(PrefConst.PRE_BLANCE, blance);
    }

    /**
     * 获取银行卡
     * @return
     */
    public static String getBlance() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_BLANCE, "");
    }

    /**
     * 保存无账户查询的手机
     * @param userName
     */
    public static void saveNoUser(String userName) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_NO, userName);
    }


    /**
     * 获取无账户查询的手机
     * @return
     */
    public static String getNoUser() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_NO, "");
    }

    /**
     * 保存Host
     * @param host
     */
    public static void saveHost(String host) {
        Logger.d("保存HOST" + host);
        AppContext.getPreUtils().put(PrefConst.PRE_HOST, "http://"+host);
    }

    public static String getHost() {
        Logger.d("获取HOST" + AppContext.getPreUtils().getString(PrefConst.PRE_HOST, "http://192.168.19.58:8080/"));
        return AppContext.getPreUtils().getString(PrefConst.PRE_HOST, "http://192.168.19.58:8080");
    }
    /**
     * 保存纬度
     * @param mLatitude
     */
    public static void saveLat(double mLatitude) {
        AppContext.getPreUtils().put(PrefConst.PRE_LAT,mLatitude+"");
    }

    public static String getLat() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_LAT, "");

    }

    /**
     * 保存纬度
     * @param mLatitude
     */
    public static void saveLong(double mLatitude) {
        AppContext.getPreUtils().put(PrefConst.PRE_LONG,mLatitude+"");
    }

    public static String getLong() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_LONG, "");

    }

    /**
     * 保存用户词典
     * @param s
     */
    public static void saveUserWord(String s) {
        AppContext.getPreUtils().put(PrefConst.PRE_USER_WORD, s);
    }

    /**
     * 获取用户词典
     * @return
     */
    public static String getUserWord() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_USER_WORD, "");
    }
    /**保存用户收藏站点状态*/
    public static void  setIsCollection(Boolean b){
        AppContext.getPreUtils().put(PrefConst.PRE_CURRENT_ISCOLLECTION, b);
    }

    public static void  getIsCollection(){
        AppContext.getPreUtils().put(PrefConst.PRE_CURRENT_ISCOLLECTION, "");
    }

    /**
     * 保存屏幕分辨率宽带
     * @param width
     */
    public static void saveScreenWidth(int width) {
        AppContext.getPreUtils().put(PrefConst.PRE_SCREEN_WIDTH, width);
    }

    /**
     * 获取屏幕分辨率宽度
     * @return
     */
    public static int getScreenWidth() {
        return AppContext.getPreUtils().getInt(PrefConst.PRE_SCREEN_WIDTH, 720);
    }


    /**
     * 保存屏幕分辨率高度
     * @param height
     */
    public static void saveScreenHeight(int height) {
        AppContext.getPreUtils().put(PrefConst.PRE_SCREEN_HEIGHT, height);
    }

    /**
     * 获取屏幕分辨率高度
     * @returnL
     */
    public static int getScreenHeight() {
        return AppContext.getPreUtils().getInt(PrefConst.PRE_SCREEN_HEIGHT, 1280);
    }

    public static void logout() {
        RetrofitManager.setmRetrofit(null);
        UserPre.saveAuthBean("pendingSubmit");
        UserPre.saveUserId("");
        UserPre.saveUserName("");
        UserPre.setCarIsAuth(false);
        UserPre.setToken("");
        UserPre.saveUserLogo("");
        UserPre.setGender("");
        UserPre.setNickName("");
        UserPre.setPhoneCall("");
        UserPre.setUserStatus("");
    }

    /**
     * 报存状态栏的高度
     * @param statusBarHeight
     */
    public static void saveStatusBarHeight(int statusBarHeight) {
        AppContext.getPreUtils().put(PrefConst.PRE_STATUS_BAR_HEIGHT, statusBarHeight);
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public static int getStatusBarHeight() {
        return AppContext.getPreUtils().getInt(PrefConst.PRE_STATUS_BAR_HEIGHT, 50);
    }


    /**
     * 保存搜索记录
     * @param searchContent
     */
    public static void saveSearchHistory(String searchContent) {
        AppContext.getPreUtils().put(PrefConst.PRE_SEARCH_CONTENT, searchContent);
    }


    /**
     * 获取搜索记录
     * @return
     */
    public static String getSearchHistory() {
        return AppContext.getPreUtils().getString(PrefConst.PRE_SEARCH_CONTENT, "");
    }


    /**
     * 保存是否是第一次进入
     * @param isOne
     */
    public static void saveIsOne(boolean isOne) {
        AppContext.getPreUtils().put(PrefConst.PRE_IS_ONE, isOne);
    }

    /**
     * 获取是否是第一次进入
     * @return
     */
    public static boolean getIsOne() {
        return AppContext.getPreUtils().getBoolean(PrefConst.PRE_IS_ONE, true);
    }


    /**
     * 保存当前的版本号
     * @param code
     */
    public static void saveCurrentCode(int code) {
        AppContext.getPreUtils().put(PrefConst.PRE_CURRENT_VERSION_CODE, code);
    }

    /**
     * 获取当前的版本
     * @return
     */
    public static int getCurrentCode() {
        return AppContext.getPreUtils().getInt(PrefConst.PRE_CURRENT_VERSION_CODE, 1);
    }
}
