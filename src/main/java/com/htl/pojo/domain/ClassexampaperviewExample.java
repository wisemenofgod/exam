package com.htl.pojo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassexampaperviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ClassexampaperviewExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andExampapernameIsNull() {
            addCriterion("examPaperName is null");
            return (Criteria) this;
        }

        public Criteria andExampapernameIsNotNull() {
            addCriterion("examPaperName is not null");
            return (Criteria) this;
        }

        public Criteria andExampapernameEqualTo(String value) {
            addCriterion("examPaperName =", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameNotEqualTo(String value) {
            addCriterion("examPaperName <>", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameGreaterThan(String value) {
            addCriterion("examPaperName >", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameGreaterThanOrEqualTo(String value) {
            addCriterion("examPaperName >=", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameLessThan(String value) {
            addCriterion("examPaperName <", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameLessThanOrEqualTo(String value) {
            addCriterion("examPaperName <=", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameLike(String value) {
            addCriterion("examPaperName like", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameNotLike(String value) {
            addCriterion("examPaperName not like", value, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameIn(List<String> values) {
            addCriterion("examPaperName in", values, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameNotIn(List<String> values) {
            addCriterion("examPaperName not in", values, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameBetween(String value1, String value2) {
            addCriterion("examPaperName between", value1, value2, "exampapername");
            return (Criteria) this;
        }

        public Criteria andExampapernameNotBetween(String value1, String value2) {
            addCriterion("examPaperName not between", value1, value2, "exampapername");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
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

        public Criteria andCreatpersonEqualTo(String value) {
            addCriterion("creatperson =", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotEqualTo(String value) {
            addCriterion("creatperson <>", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonGreaterThan(String value) {
            addCriterion("creatperson >", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonGreaterThanOrEqualTo(String value) {
            addCriterion("creatperson >=", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonLessThan(String value) {
            addCriterion("creatperson <", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonLessThanOrEqualTo(String value) {
            addCriterion("creatperson <=", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonLike(String value) {
            addCriterion("creatperson like", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotLike(String value) {
            addCriterion("creatperson not like", value, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonIn(List<String> values) {
            addCriterion("creatperson in", values, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotIn(List<String> values) {
            addCriterion("creatperson not in", values, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonBetween(String value1, String value2) {
            addCriterion("creatperson between", value1, value2, "creatperson");
            return (Criteria) this;
        }

        public Criteria andCreatpersonNotBetween(String value1, String value2) {
            addCriterion("creatperson not between", value1, value2, "creatperson");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberIsNull() {
            addCriterion("questionNumber is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberIsNotNull() {
            addCriterion("questionNumber is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberEqualTo(Integer value) {
            addCriterion("questionNumber =", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberNotEqualTo(Integer value) {
            addCriterion("questionNumber <>", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberGreaterThan(Integer value) {
            addCriterion("questionNumber >", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionNumber >=", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberLessThan(Integer value) {
            addCriterion("questionNumber <", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberLessThanOrEqualTo(Integer value) {
            addCriterion("questionNumber <=", value, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberIn(List<Integer> values) {
            addCriterion("questionNumber in", values, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberNotIn(List<Integer> values) {
            addCriterion("questionNumber not in", values, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberBetween(Integer value1, Integer value2) {
            addCriterion("questionNumber between", value1, value2, "questionnumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("questionNumber not between", value1, value2, "questionnumber");
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