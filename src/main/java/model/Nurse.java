package model;

public class Nurse {

    private List<Appointment> appointmentList = new ArrayList<>();
    private Boolean nursePermission;
    private List<Patient> dailyPatientList = new ArrayList<>();

    public Nurse(Boolean nursePermission, List<Appointment> appointmentList, List<Patient> dailyPatientList) {

        if (appointmentList == null || appointmentList.size() < 0 )
            throw new IllegalArgumentException();
        if (dailyPatientList == null || dailyPatientList.size() < 0)
            throw new IllegalArgumentException();


        this.nursePermission = nursePermission;
        this.appointmentList = appointmentList;
        this.dailyPatientList = dailyPatientList;
    }
    public Nurse() {}

    public isANurse() { return nursePermission; }

    public List<Appointment> getAppointmentList() { return appointmentList; }

    public List<Patient> getDailyPatientList() { return dailyPatientList; }

}
