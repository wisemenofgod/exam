package com.htl.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QuestionExample() {
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

        public Criteria andQNameIsNull() {
            addCriterion("q_name is null");
            return (Criteria) this;
        }

        public Criteria andQNameIsNotNull() {
            addCriterion("q_name is not null");
            return (Criteria) this;
        }

        public Criteria andQNameEqualTo(String value) {
            addCriterion("q_name =", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameNotEqualTo(String value) {
            addCriterion("q_name <>", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameGreaterThan(String value) {
            addCriterion("q_name >", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameGreaterThanOrEqualTo(String value) {
            addCriterion("q_name >=", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameLessThan(String value) {
            addCriterion("q_name <", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameLessThanOrEqualTo(String value) {
            addCriterion("q_name <=", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameLike(String value) {
            addCriterion("q_name like", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameNotLike(String value) {
            addCriterion("q_name not like", value, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameIn(List<String> values) {
            addCriterion("q_name in", values, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameNotIn(List<String> values) {
            addCriterion("q_name not in", values, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameBetween(String value1, String value2) {
            addCriterion("q_name between", value1, value2, "qName");
            return (Criteria) this;
        }

        public Criteria andQNameNotBetween(String value1, String value2) {
            addCriterion("q_name not between", value1, value2, "qName");
            return (Criteria) this;
        }

        public Criteria andQAnsaIsNull() {
            addCriterion("q_ansA is null");
            return (Criteria) this;
        }

        public Criteria andQAnsaIsNotNull() {
            addCriterion("q_ansA is not null");
            return (Criteria) this;
        }

        public Criteria andQAnsaEqualTo(String value) {
            addCriterion("q_ansA =", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaNotEqualTo(String value) {
            addCriterion("q_ansA <>", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaGreaterThan(String value) {
            addCriterion("q_ansA >", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaGreaterThanOrEqualTo(String value) {
            addCriterion("q_ansA >=", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaLessThan(String value) {
            addCriterion("q_ansA <", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaLessThanOrEqualTo(String value) {
            addCriterion("q_ansA <=", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaLike(String value) {
            addCriterion("q_ansA like", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaNotLike(String value) {
            addCriterion("q_ansA not like", value, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaIn(List<String> values) {
            addCriterion("q_ansA in", values, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaNotIn(List<String> values) {
            addCriterion("q_ansA not in", values, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaBetween(String value1, String value2) {
            addCriterion("q_ansA between", value1, value2, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsaNotBetween(String value1, String value2) {
            addCriterion("q_ansA not between", value1, value2, "qAnsa");
            return (Criteria) this;
        }

        public Criteria andQAnsbIsNull() {
            addCriterion("q_ansB is null");
            return (Criteria) this;
        }

        public Criteria andQAnsbIsNotNull() {
            addCriterion("q_ansB is not null");
            return (Criteria) this;
        }

        public Criteria andQAnsbEqualTo(String value) {
            addCriterion("q_ansB =", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbNotEqualTo(String value) {
            addCriterion("q_ansB <>", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbGreaterThan(String value) {
            addCriterion("q_ansB >", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbGreaterThanOrEqualTo(String value) {
            addCriterion("q_ansB >=", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbLessThan(String value) {
            addCriterion("q_ansB <", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbLessThanOrEqualTo(String value) {
            addCriterion("q_ansB <=", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbLike(String value) {
            addCriterion("q_ansB like", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbNotLike(String value) {
            addCriterion("q_ansB not like", value, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbIn(List<String> values) {
            addCriterion("q_ansB in", values, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbNotIn(List<String> values) {
            addCriterion("q_ansB not in", values, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbBetween(String value1, String value2) {
            addCriterion("q_ansB between", value1, value2, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnsbNotBetween(String value1, String value2) {
            addCriterion("q_ansB not between", value1, value2, "qAnsb");
            return (Criteria) this;
        }

        public Criteria andQAnscIsNull() {
            addCriterion("q_ansC is null");
            return (Criteria) this;
        }

        public Criteria andQAnscIsNotNull() {
            addCriterion("q_ansC is not null");
            return (Criteria) this;
        }

        public Criteria andQAnscEqualTo(String value) {
            addCriterion("q_ansC =", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscNotEqualTo(String value) {
            addCriterion("q_ansC <>", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscGreaterThan(String value) {
            addCriterion("q_ansC >", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscGreaterThanOrEqualTo(String value) {
            addCriterion("q_ansC >=", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscLessThan(String value) {
            addCriterion("q_ansC <", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscLessThanOrEqualTo(String value) {
            addCriterion("q_ansC <=", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscLike(String value) {
            addCriterion("q_ansC like", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscNotLike(String value) {
            addCriterion("q_ansC not like", value, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscIn(List<String> values) {
            addCriterion("q_ansC in", values, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscNotIn(List<String> values) {
            addCriterion("q_ansC not in", values, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscBetween(String value1, String value2) {
            addCriterion("q_ansC between", value1, value2, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnscNotBetween(String value1, String value2) {
            addCriterion("q_ansC not between", value1, value2, "qAnsc");
            return (Criteria) this;
        }

        public Criteria andQAnsdIsNull() {
            addCriterion("q_ansD is null");
            return (Criteria) this;
        }

        public Criteria andQAnsdIsNotNull() {
            addCriterion("q_ansD is not null");
            return (Criteria) this;
        }

        public Criteria andQAnsdEqualTo(String value) {
            addCriterion("q_ansD =", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdNotEqualTo(String value) {
            addCriterion("q_ansD <>", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdGreaterThan(String value) {
            addCriterion("q_ansD >", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdGreaterThanOrEqualTo(String value) {
            addCriterion("q_ansD >=", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdLessThan(String value) {
            addCriterion("q_ansD <", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdLessThanOrEqualTo(String value) {
            addCriterion("q_ansD <=", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdLike(String value) {
            addCriterion("q_ansD like", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdNotLike(String value) {
            addCriterion("q_ansD not like", value, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdIn(List<String> values) {
            addCriterion("q_ansD in", values, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdNotIn(List<String> values) {
            addCriterion("q_ansD not in", values, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdBetween(String value1, String value2) {
            addCriterion("q_ansD between", value1, value2, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsdNotBetween(String value1, String value2) {
            addCriterion("q_ansD not between", value1, value2, "qAnsd");
            return (Criteria) this;
        }

        public Criteria andQAnsIsNull() {
            addCriterion("q_ans is null");
            return (Criteria) this;
        }

        public Criteria andQAnsIsNotNull() {
            addCriterion("q_ans is not null");
            return (Criteria) this;
        }

        public Criteria andQAnsEqualTo(String value) {
            addCriterion("q_ans =", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsNotEqualTo(String value) {
            addCriterion("q_ans <>", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsGreaterThan(String value) {
            addCriterion("q_ans >", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsGreaterThanOrEqualTo(String value) {
            addCriterion("q_ans >=", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsLessThan(String value) {
            addCriterion("q_ans <", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsLessThanOrEqualTo(String value) {
            addCriterion("q_ans <=", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsLike(String value) {
            addCriterion("q_ans like", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsNotLike(String value) {
            addCriterion("q_ans not like", value, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsIn(List<String> values) {
            addCriterion("q_ans in", values, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsNotIn(List<String> values) {
            addCriterion("q_ans not in", values, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsBetween(String value1, String value2) {
            addCriterion("q_ans between", value1, value2, "qAns");
            return (Criteria) this;
        }

        public Criteria andQAnsNotBetween(String value1, String value2) {
            addCriterion("q_ans not between", value1, value2, "qAns");
            return (Criteria) this;
        }

        public Criteria andQTypeIsNull() {
            addCriterion("q_type is null");
            return (Criteria) this;
        }

        public Criteria andQTypeIsNotNull() {
            addCriterion("q_type is not null");
            return (Criteria) this;
        }

        public Criteria andQTypeEqualTo(Integer value) {
            addCriterion("q_type =", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeNotEqualTo(Integer value) {
            addCriterion("q_type <>", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeGreaterThan(Integer value) {
            addCriterion("q_type >", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("q_type >=", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeLessThan(Integer value) {
            addCriterion("q_type <", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeLessThanOrEqualTo(Integer value) {
            addCriterion("q_type <=", value, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeIn(List<Integer> values) {
            addCriterion("q_type in", values, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeNotIn(List<Integer> values) {
            addCriterion("q_type not in", values, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeBetween(Integer value1, Integer value2) {
            addCriterion("q_type between", value1, value2, "qType");
            return (Criteria) this;
        }

        public Criteria andQTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("q_type not between", value1, value2, "qType");
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