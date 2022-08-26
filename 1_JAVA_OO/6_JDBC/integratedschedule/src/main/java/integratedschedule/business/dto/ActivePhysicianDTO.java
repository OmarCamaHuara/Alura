package integratedschedule.business.dto;

public class ActivePhysicianDTO {
    @Schema(description = "Physician code", example = "4919")
    private Integer physicianCode;

    private String physicianName;

    private  String phycisianIsActive;

    private String phyicianIsOpenSchedule;

}
