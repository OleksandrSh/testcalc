CREATE TABLE IF NOT EXISTS `oasis`.`ui_dashboard` (
  `uid_id` INT NOT NULL AUTO_INCREMENT,
  `uid_name` VARCHAR(45) NULL,
  `uid_su_userid` int(11) NOT NULL,
  `uid_is_public` TINYINT(1) NULL,
  `uid_is_trash` TINYINT(1) NULL,
  `uid_layout_options` TEXT NULL,
  PRIMARY KEY (`uid_id`),
  UNIQUE INDEX `uid_id` (`uid_id` ASC),
    CONSTRAINT `fk_su_userid`
    FOREIGN KEY (`uid_su_userid`)
    REFERENCES `oasis`.`security_user` (`su_userid`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE  = InnoDB  DEFAULT CHARSET=latin1;
 

CREATE TABLE IF NOT EXISTS `oasis`.`ui_widget` (
  `uiw_id` INT NOT NULL AUTO_INCREMENT,
  `uiw_widget_parametrs` TEXT NULL,
  `uiw_uid_id` INT NOT NULL,
  PRIMARY KEY (`uiw_id`),
  UNIQUE INDEX `uiw_id` (`uiw_id` ASC),
    CONSTRAINT `fk_uiw_uid_id`
    FOREIGN KEY (`uiw_uid_id`)
    REFERENCES `oasis`.`ui_dashboard` (`uid_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `oasis`.`ui_dashboard_share` (
  `uids_sug_groupid` INT NOT NULL,
  `uids_uid_id` INT NOT NULL,
  CONSTRAINT `fk_uids_uid_id`
    FOREIGN KEY (`uids_uid_id`)
    REFERENCES `oasis`.`ui_dashboard` (`uid_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB  DEFAULT CHARSET=latin1;

