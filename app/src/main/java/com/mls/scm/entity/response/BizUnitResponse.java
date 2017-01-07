package com.mls.scm.entity.response;

import com.mls.scm.entity.response.common.CommResponse;

import java.util.List;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public class BizUnitResponse extends CommResponse {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * invcBankAccount :
         * invcName :
         * bizType : hr
         * code : 110
         * address : 南京栖霞区紫东国际创意园
         * invcBankName :
         * invcPhone :
         * isStopBiz : false
         * invcAddress :
         * remark : 测试数据
         * employee : null
         * linkman : 丁琦琦
         * taxRate : null
         * simpleName : null
         * phone : 15251898176
         * invcTaxNo :
         * isEnabled : false
         * name : 南京人力外包公司
         * mnemonicCode : null
         * id : 1171296441700847616
         * fax : 025-983336879
         * createDate : 1483165811000
         */

        private String invcBankAccount;
        private String invcName;
        private String bizType;
        private String code;
        private String address;
        private String invcBankName;
        private String invcPhone;
        private boolean isStopBiz;
        private String invcAddress;
        private String remark;
        private Object employee;
        private String linkman;
        private Object taxRate;
        private Object simpleName;
        private String phone;
        private String invcTaxNo;
        private boolean isEnabled;
        private String name;
        private Object mnemonicCode;
        private String id;
        private String fax;
        private long createDate;

        public String getInvcBankAccount() {
            return invcBankAccount;
        }

        public void setInvcBankAccount(String invcBankAccount) {
            this.invcBankAccount = invcBankAccount;
        }

        public String getInvcName() {
            return invcName;
        }

        public void setInvcName(String invcName) {
            this.invcName = invcName;
        }

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getInvcBankName() {
            return invcBankName;
        }

        public void setInvcBankName(String invcBankName) {
            this.invcBankName = invcBankName;
        }

        public String getInvcPhone() {
            return invcPhone;
        }

        public void setInvcPhone(String invcPhone) {
            this.invcPhone = invcPhone;
        }

        public boolean isIsStopBiz() {
            return isStopBiz;
        }

        public void setIsStopBiz(boolean isStopBiz) {
            this.isStopBiz = isStopBiz;
        }

        public String getInvcAddress() {
            return invcAddress;
        }

        public void setInvcAddress(String invcAddress) {
            this.invcAddress = invcAddress;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getEmployee() {
            return employee;
        }

        public void setEmployee(Object employee) {
            this.employee = employee;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public Object getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(Object taxRate) {
            this.taxRate = taxRate;
        }

        public Object getSimpleName() {
            return simpleName;
        }

        public void setSimpleName(Object simpleName) {
            this.simpleName = simpleName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getInvcTaxNo() {
            return invcTaxNo;
        }

        public void setInvcTaxNo(String invcTaxNo) {
            this.invcTaxNo = invcTaxNo;
        }

        public boolean isIsEnabled() {
            return isEnabled;
        }

        public void setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getMnemonicCode() {
            return mnemonicCode;
        }

        public void setMnemonicCode(Object mnemonicCode) {
            this.mnemonicCode = mnemonicCode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }
    }
}
