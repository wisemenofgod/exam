package com.htl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClazzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ClazzExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCDetailsIsNull() {
            addCriterion("c_details is null");
            return (Criteria) this;
        }

        public Criteria andCDetailsIsNotNull() {
            addCriterion("c_details is not null");
            return (Criteria) this;
        }

        public Criteria andCDetailsEqualTo(String value) {
            addCriterion("c_details =", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsNotEqualTo(String value) {
            addCriterion("c_details <>", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsGreaterThan(String value) {
            addCriterion("c_details >", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("c_details >=", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsLessThan(String value) {
            addCriterion("c_details <", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsLessThanOrEqualTo(String value) {
            addCriterion("c_details <=", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsLike(String value) {
            addCriterion("c_details like", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsNotLike(String value) {
            addCriterion("c_details not like", value, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsIn(List<String> values) {
            addCriterion("c_details in", values, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsNotIn(List<String> values) {
            addCriterion("c_details not in", values, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsBetween(String value1, String value2) {
            addCriterion("c_details between", value1, value2, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCDetailsNotBetween(String value1, String value2) {
            addCriterion("c_details not between", value1, value2, "cDetails");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTIme is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTIme is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTIme =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTIme <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTIme >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTIme >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTIme <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTIme <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTIme in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTIme not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTIme between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTIme not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreatpersonIsNull() {
            addCriterion("creatperson is null");
            return (Criteria) this;
        }

        public Criteria andCreatpersonIsNotNull() {
            addCriterion("creatperson is not null");
            return (Criteria) this;
        }

        public Criteria andCreatpersonEqualTo(Integer value) {
            addCriterion("creatperson =", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotEqualTo(Integer value) {
            addCriterion("creatperson <>", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonGreaterThan(Integer value) {
            addCriterion("creatperson >", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("creatperson >=", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonLessThan(Integer value) {
            addCriterion("creatperson <", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonLessThanOrEqualTo(Integer value) {
            addCriterion("creatperson <=", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonIn(List<Integer> values) {
            addCriterion("creatperson in", values, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotIn(List<Integer> values) {
            addCriterion("creatperson not in", values, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonBetween(Integer value1, Integer value2) {
            addCriterion("creatperson between", value1, value2, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotBetween(Integer value1, Integer value2) {
            addCriterion("creatperson not between", value1, value2, "creatperson");
            return (Criteria) this;
        }
    }

    /**
     */
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