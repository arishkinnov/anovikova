DROP DATABASE IF EXISTS `hospital`;
CREATE DATABASE `hospital` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE TABLE `hospital`.`doctor`
(
    `doctor_id` int PRIMARY KEY AUTO_INCREMENT,
    `name`      varchar(64),
    `last_name`  varchar(64),
    `active`    tinyint (1) default 1 COMMENT 'Активный доктор - 1, Не активный - 0'
);

CREATE TABLE `hospital`.`patient`
(
    `patient_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name`       VARCHAR(64),
    `last_name`   VARCHAR(64),
    `active`    TINYINT (1) DEFAULT 1 COMMENT 'Активный пациент - 1, Не активный - 0'
);

CREATE TABLE `hospital`.`doctor_appointments`
(
    `doctor_appointments_id` INT AUTO_INCREMENT,
    `doctor_id` INT NOT NULL,
    `patient_id` INT NOT NULL,
    CONSTRAINT `doctor_appointments_pk`
        PRIMARY KEY (`doctor_appointments_id`),
    CONSTRAINT `doctor_appointments_doctor_doctor_id_fk`
        FOREIGN KEY (`doctor_id`) REFERENCES `hospital`.`doctor` (`doctor_id`),
    CONSTRAINT `doctor_appointments_patient_patient_id_fk`
        FOREIGN KEY (`patient_id`) REFERENCES `hospital`.`patient` (`patient_id`)
)
COMMENT 'Прием пациентов доктором';

CREATE TABLE `hospital`.`complaints`
(
    `complaints_id` INT AUTO_INCREMENT,
    `patient_id`    INT,
    `description`   VARCHAR(256) COMMENT 'Жалоба пациента в свободной форме',
    CONSTRAINT complaints_pk
        PRIMARY KEY (complaints_id),
    CONSTRAINT complaints_patient_patient_id_fk
        FOREIGN KEY (patient_id) REFERENCES `hospital`.`patient` (`patient_id`)
        ON DELETE CASCADE
)
COMMENT 'Жалобы пациентов';


CREATE TABLE `hospital`.`patient_complaints`
(
    `doctor_appointments_id` int,
    `complaints_id`          int,
    CONSTRAINT patient_complaints_pk
        PRIMARY KEY (doctor_appointments_id),
    CONSTRAINT patient_complaints_doctor_appointments_doctor_appointments_id_fk
        FOREIGN KEY (doctor_appointments_id) REFERENCES doctor_appointments (doctor_appointments_id)
            ON DELETE CASCADE,
    CONSTRAINT `patient_complaints_complaints_complaints_id_fk`
        FOREIGN KEY (complaints_id) REFERENCES `hospital`.`complaints` (`complaints_id`)
            ON DELETE CASCADE
)
COMMENT 'Жалобы пациента во время приема у доктора';


CREATE TABLE `hospital`.`diseases`
(
    `disease_id`   int PRIMARY KEY AUTO_INCREMENT,
    `disease_name` varchar(128) NOT NULL
)
COMMENT 'Справочник заболеваний';

CREATE TABLE `hospital`.`diagnosis`
(
    `diagnosis_id`           int AUTO_INCREMENT,
    `doctor_appointments_id` int,
    `disease_id`             int,
    CONSTRAINT `diagnosis_pk`
        PRIMARY KEY (diagnosis_id),
    CONSTRAINT `diagnosis_doctor_appointments_doctor_appointments_id_fk`
        FOREIGN KEY (doctor_appointments_id) REFERENCES `hospital`.`doctor_appointments` (`doctor_appointments_id`),
    CONSTRAINT `diagnosis_doctor_disease_disease_id_fk`
        FOREIGN KEY (disease_id) REFERENCES `hospital`.`diseases` (`disease_id`)
)
COMMENT 'Поставленный диагноз доктором во время приема пациента';

CREATE TABLE `hospital`.`symptoms`
(
    `symptoms_id`  int PRIMARY KEY AUTO_INCREMENT,
    `description` varchar(256)
)
COMMENT 'Справочник симптомов';

CREATE TABLE `hospital`.`diseases_symptoms`
(
    `disease_id` int,
    `symptom_id` int,
        CONSTRAINT diseases_symptoms_pk
        PRIMARY KEY (disease_id, symptom_id),
        CONSTRAINT diseases_symptoms_disease_disease_id_fk
            FOREIGN KEY (disease_id) REFERENCES `hospital`.`diseases` (`disease_id`),
        CONSTRAINT diseases_symptoms_symptom_symptom_id_fk
            FOREIGN KEY (symptom_id) REFERENCES `hospital`.`symptoms` (`symptoms_id`)

)
COMMENT 'Симптомы заболевания';
