/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package studManager.ui;

import java.util.Calendar;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Rob Winch
 */
public class Student {

    private Long id;
    @NotEmpty(message = "First Name is required.")
    private String firstName;
    @NotEmpty(message = "Second Name is required.")
    private String secondName;
    @NotEmpty(message = "Last Name is required.")
    private String lastName;
    @NotEmpty(message = "Birthday is required.")
    private String birthdayDate;
    @NotEmpty(message = "Group Name is required.")
    private String groupName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    @Override
    public String toString() {
        return this.firstName + " "+ this.secondName + " "+ this.lastName;
    }

}
