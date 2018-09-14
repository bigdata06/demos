package org.said.demo;

import org.said.demo.model.Student;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
public class CustomErrorType extends Student {

    private String errorMessage;

        public CustomErrorType(final String errorMessage){
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
}
