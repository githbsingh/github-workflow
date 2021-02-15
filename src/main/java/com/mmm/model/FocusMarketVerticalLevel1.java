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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_focus_market_vertical_Level1")
public class FocusMarketVerticalLevel1 {

    public FocusMarketVerticalLevel1() {
    }

    public FocusMarketVerticalLevel1(long focusMrktVrtLvl1Id) {
	super();
	this.focusMrktVrtLvl1Id = focusMrktVrtLvl1Id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOCUS_MRKT_VRT_LVL1_ID")
    @NaturalId
    private long focusMrktVrtLvl1Id;

    @Column(name = "FOCUS_MRKT_VRT_LVL1_NAME")
    private String focusMrktVrtLvl1Name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "focusMarketVerticalLevel1")
    @JsonIgnore
    private Set<FocusMarketVerticalLevel2> focusMarketVerticalLevel2 = new HashSet<FocusMarketVerticalLevel2>();

    @OneToMany(mappedBy = "focusMarketVerticalLevel1", cascade = { CascadeType.PERSIST,
	    CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UserMarketVerticalLevel> userMarketVerticalLevel = new HashSet<UserMarketVerticalLevel>();

    public long getFocusMrktVrtLvl1Id() {
	return focusMrktVrtLvl1Id;
    }

    public void setFocusMrktVrtLvl1Id(long focusMrktVrtLvl1Id) {
	this.focusMrktVrtLvl1Id = focusMrktVrtLvl1Id;
    }

    public String getFocusMrktVrtLvl1Name() {
	return focusMrktVrtLvl1Name;
    }

    public void setFocusMrktVrtLvl1Name(String focusMrktVrtLvl1Name) {
	this.focusMrktVrtLvl1Name = focusMrktVrtLvl1Name;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	FocusMarketVerticalLevel1 mrktVrtLvl1 = (FocusMarketVerticalLevel1) o;
	return Objects.equals(focusMrktVrtLvl1Id, mrktVrtLvl1.focusMrktVrtLvl1Id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(focusMrktVrtLvl1Id);
    }

    public Set<UserMarketVerticalLevel> getUserMarketVerticalLevel() {
	return userMarketVerticalLevel;
    }

    public void setUserMarketVerticalLevel(Set<UserMarketVerticalLevel> userMarketVerticalLevel) {
	this.userMarketVerticalLevel = userMarketVerticalLevel;
    }

    @Override
    public String toString() {
	return "FocusMarketVerticalLevel1 [focusMrktVrtLvl1Id=" + focusMrktVrtLvl1Id + ", focusMrktVrtLvl1Name="
		+ focusMrktVrtLvl1Name + ", focusMarketVerticalLevel2=" + focusMarketVerticalLevel2
		+ ", userMarketVerticalLevel=" + userMarketVerticalLevel + "]";
    }

}
