package com.ultrapower.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdcBmPortAssetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdcBmPortAssetExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPkBmPortAssetIsNull() {
            addCriterion("PK_BM_PORT_ASSET is null");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetIsNotNull() {
            addCriterion("PK_BM_PORT_ASSET is not null");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetEqualTo(String value) {
            addCriterion("PK_BM_PORT_ASSET =", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetNotEqualTo(String value) {
            addCriterion("PK_BM_PORT_ASSET <>", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetGreaterThan(String value) {
            addCriterion("PK_BM_PORT_ASSET >", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetGreaterThanOrEqualTo(String value) {
            addCriterion("PK_BM_PORT_ASSET >=", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetLessThan(String value) {
            addCriterion("PK_BM_PORT_ASSET <", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetLessThanOrEqualTo(String value) {
            addCriterion("PK_BM_PORT_ASSET <=", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetLike(String value) {
            addCriterion("PK_BM_PORT_ASSET like", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetNotLike(String value) {
            addCriterion("PK_BM_PORT_ASSET not like", value, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetIn(List<String> values) {
            addCriterion("PK_BM_PORT_ASSET in", values, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetNotIn(List<String> values) {
            addCriterion("PK_BM_PORT_ASSET not in", values, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetBetween(String value1, String value2) {
            addCriterion("PK_BM_PORT_ASSET between", value1, value2, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortAssetNotBetween(String value1, String value2) {
            addCriterion("PK_BM_PORT_ASSET not between", value1, value2, "pkBmPortAsset");
            return (Criteria) this;
        }

        public Criteria andPkBmPortIsNull() {
            addCriterion("PK_BM_PORT is null");
            return (Criteria) this;
        }

        public Criteria andPkBmPortIsNotNull() {
            addCriterion("PK_BM_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andPkBmPortEqualTo(String value) {
            addCriterion("PK_BM_PORT =", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortNotEqualTo(String value) {
            addCriterion("PK_BM_PORT <>", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortGreaterThan(String value) {
            addCriterion("PK_BM_PORT >", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortGreaterThanOrEqualTo(String value) {
            addCriterion("PK_BM_PORT >=", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortLessThan(String value) {
            addCriterion("PK_BM_PORT <", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortLessThanOrEqualTo(String value) {
            addCriterion("PK_BM_PORT <=", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortLike(String value) {
            addCriterion("PK_BM_PORT like", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortNotLike(String value) {
            addCriterion("PK_BM_PORT not like", value, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortIn(List<String> values) {
            addCriterion("PK_BM_PORT in", values, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortNotIn(List<String> values) {
            addCriterion("PK_BM_PORT not in", values, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortBetween(String value1, String value2) {
            addCriterion("PK_BM_PORT between", value1, value2, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkBmPortNotBetween(String value1, String value2) {
            addCriterion("PK_BM_PORT not between", value1, value2, "pkBmPort");
            return (Criteria) this;
        }

        public Criteria andPkAssetIsNull() {
            addCriterion("PK_ASSET is null");
            return (Criteria) this;
        }

        public Criteria andPkAssetIsNotNull() {
            addCriterion("PK_ASSET is not null");
            return (Criteria) this;
        }

        public Criteria andPkAssetEqualTo(String value) {
            addCriterion("PK_ASSET =", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotEqualTo(String value) {
            addCriterion("PK_ASSET <>", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetGreaterThan(String value) {
            addCriterion("PK_ASSET >", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ASSET >=", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLessThan(String value) {
            addCriterion("PK_ASSET <", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLessThanOrEqualTo(String value) {
            addCriterion("PK_ASSET <=", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetLike(String value) {
            addCriterion("PK_ASSET like", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotLike(String value) {
            addCriterion("PK_ASSET not like", value, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetIn(List<String> values) {
            addCriterion("PK_ASSET in", values, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotIn(List<String> values) {
            addCriterion("PK_ASSET not in", values, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetBetween(String value1, String value2) {
            addCriterion("PK_ASSET between", value1, value2, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andPkAssetNotBetween(String value1, String value2) {
            addCriterion("PK_ASSET not between", value1, value2, "pkAsset");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNull() {
            addCriterion("PROV_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvCodeIsNotNull() {
            addCriterion("PROV_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvCodeEqualTo(String value) {
            addCriterion("PROV_CODE =", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotEqualTo(String value) {
            addCriterion("PROV_CODE <>", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThan(String value) {
            addCriterion("PROV_CODE >", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROV_CODE >=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThan(String value) {
            addCriterion("PROV_CODE <", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLessThanOrEqualTo(String value) {
            addCriterion("PROV_CODE <=", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeLike(String value) {
            addCriterion("PROV_CODE like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotLike(String value) {
            addCriterion("PROV_CODE not like", value, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeIn(List<String> values) {
            addCriterion("PROV_CODE in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotIn(List<String> values) {
            addCriterion("PROV_CODE not in", values, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeBetween(String value1, String value2) {
            addCriterion("PROV_CODE between", value1, value2, "provCode");
            return (Criteria) this;
        }

        public Criteria andProvCodeNotBetween(String value1, String value2) {
            addCriterion("PROV_CODE not between", value1, value2, "provCode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}