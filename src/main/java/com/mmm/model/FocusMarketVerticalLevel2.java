package com.mmm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_focus_market_vertical_Level2")
public class FocusMarketVerticalLevel2 {

    public FocusMarketVerticalLevel2() {
    }

    public FocusMarketVerticalLevel2(long focusMrktVrtLvl2Id) {
	super();
	this.focusMrktVrtLvl2Id = focusMrktVrtLvl2Id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOCUS_MRKT_VRT_LVL2_ID")
    @NaturalId
    private long focusMrktVrtLvl2Id;

    @Column(name = "FOCUS_MRKT_VRT_LVL2_NAME")
    private String focusMrktVrtLvl2Name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOCUS_MRKT_VRT_LVL1_ID", insertable = false, updatable = false)
    @JsonIgnore
    private FocusMarketVerticalLevel1 focusMarketVerticalLevel1;

    @OneToMany(mappedBy = "focusMarketVerticalLevel2", cascade = { CascadeType.PERSIST,
	    CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UserMarketVerticalLevel> userMarketVerticalLevel = new HashSet<UserMarketVerticalLevel>();

    public long getFocusMrktVrtLvl2Id() {
	return focusMrktVrtLvl2Id;
    }

    public void setFocusMrktVrtLvl2Id(long focusMrktVrtLvl2Id) {
	this.focusMrktVrtLvl2Id = focusMrktVrtLvl2Id;
    }

    public String getFocusMrktVrtLvl2Name() {
	return focusMrktVrtLvl2Name;
    }

    public void setFocusMrktVrtLvl2Name(String focusMrktVrtLvl2Name) {
	this.focusMrktVrtLvl2Name = focusMrktVrtLvl2Name;
    }

    public FocusMarketVerticalLevel1 getFocusMarketVerticalLevel1() {
	return focusMarketVerticalLevel1;
    }

    public void setFocusMarketVerticalLevel1(FocusMarketVerticalLevel1 focusMarketVerticalLevel1) {
	this.focusMarketVerticalLevel1 = focusMarketVerticalLevel1;
    }

    
    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	FocusMarketVerticalLevel2 mrktVrtLvl2 = (FocusMarketVerticalLevel2) o;
	return Objects.equals(focusMrktVrtLvl2Id, mrktVrtLvl2.focusMrktVrtLvl2Id)
		&& Objects.equals(focusMarketVerticalLevel1, mrktVrtLvl2.focusMarketVerticalLevel1);
    }

    @Override
    public int hashCode() {
	return Objects.hash(focusMrktVrtLvl2Id, focusMarketVerticalLevel1);
    }
     

    public Set<UserMarketVerticalLevel> getUserMarketVerticalLevel() {
	return userMarketVerticalLevel;
    }

    public void setUserMarketVerticalLevel(Set<UserMarketVerticalLevel> userMarketVerticalLevel) {
	this.userMarketVerticalLevel = userMarketVerticalLevel;
    }

    @Override
    public String toString() {
	return "FocusMarketVerticalLevel2 [focusMrktVrtLvl2Id=" + focusMrktVrtLvl2Id + ", focusMrktVrtLvl2Name="
		+ focusMrktVrtLvl2Name + ", focusMarketVerticalLevel1=" + focusMarketVerticalLevel1
		+ ", userMarketVerticalLevel=" + userMarketVerticalLevel + "]";
    }

}
