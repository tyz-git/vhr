package org.javaboy.vhr.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.javaboy.vhr.utils.DateConverter;
import org.javaboy.vhr.utils.NationConverter;

import java.util.Date;

public class Employee{
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;

    @ExcelProperty(value = "性别",index = 2)
    private String gender;

    @ExcelProperty(value = "出生日期", index = 3, converter = DateConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date birthday;

    @ExcelProperty(value = "身份证号", index = 4)
    private String idCard;

    @ExcelProperty(value = "婚姻状况", index = 5)
    private String wedlock;

    @ExcelIgnore
    private Integer nationId;

    @ExcelProperty(value = "政治面貌", index = 7)
    private String nativePlace;

    @ExcelIgnore
    private Integer politicId;

    @ExcelProperty(value = "邮箱", index = 8)
    private String email;

    @ExcelProperty(value = "手机号", index = 9)
    private String phone;

    @ExcelProperty(value = "家庭住址", index = 10)
    private String address;

    @ExcelProperty(value = "所属部门", index = 11)
    private Integer departmentId;

    @ExcelProperty(value = "职称", index = 13)
    private Integer jobLevelId;

    @ExcelProperty(value = "职位", index = 12)
    private Integer posId;

    @ExcelProperty(value = "聘用形式", index = 14)
    private String engageForm;

    @ExcelProperty(value = "学历", index = 15)
    private String tiptopDegree;

    @ExcelProperty(value = "专业", index = 16)
    private String specialty;

    @ExcelProperty(value = "毕业院校", index = 17)
    private String school;

    @ExcelProperty(value = "入职时间", index = 18)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date beginDate;

    @ExcelProperty(value = "工作状态", index = 19)
    private String workState;

    @ExcelProperty(value = "工号", index = 0)
    private String workID;

    @ExcelProperty(value = "合同期限(年)", index = 20)
    private Double contractTerm;

    @ExcelProperty(value = "转正时间", index = 21)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date conversionTime;

    @ExcelIgnore
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date notWorkDate;

    @ExcelProperty(value = "合同起始时间", index = 22)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date beginContract;

    @ExcelProperty(value = "合同结束时间", index = 23)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    private Date endContract;

    @ExcelIgnore
    private Integer workAge;

//    @ExcelProperty(value = "民族", index = 6, converter = NationConverter.class)
    @ExcelIgnore
    private Nation nation;
    @ExcelIgnore
    private Politicsstatus politicsstatus;
    @ExcelIgnore
    private Department department;
    @ExcelIgnore
    private JobLevel jobLevel;
    @ExcelIgnore
    private Position position;

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Politicsstatus getPoliticsstatus() {
        return politicsstatus;
    }

    public void setPoliticsstatus(Politicsstatus politicsstatus) {
        this.politicsstatus = politicsstatus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public Double getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
}