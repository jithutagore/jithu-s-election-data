package com.jithu.electionData;

public class SingleRow {
    String personId;
    String name;
    String parentName;
    String houseNumber;
    String houseName;
    String genderAndAge;
    String idCardNo;
    String boothNumber;
    String boothName;

    public SingleRow(String personId, String name, String parentName, String houseNumber, String houseName, String genderAndAge, String idCardNo, String boothNumber, String boothName) {
        this.personId = personId;
        this.name = name;
        this.parentName = parentName;
        this.houseNumber = houseNumber;
        this.houseName = houseName;
        this.genderAndAge = genderAndAge;
        this.idCardNo = idCardNo;
        this.boothNumber = boothNumber;
        this.boothName = boothName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getGenderAndAge() {
        return genderAndAge;
    }

    public void setGenderAndAge(String genderAndAge) {
        this.genderAndAge = genderAndAge;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(String boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }
}
