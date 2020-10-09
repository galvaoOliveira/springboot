package br.com.devSpringBoot.awesome.error;

public class ValidationErrorDetails extends ErrorDetails {
    private String field;
    private String fielMessage;

    public static final class Builder {
        private String titulo;
        private int status;
        private String detalhes;
        private long timestamp;
        private String developerMessage;
        private String field;
        private String fielMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fielMessage(String fielMessage) {
            this.fielMessage = fielMessage;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detalhes(String detalhes) {
            this.detalhes = detalhes;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setDeveloperMessage(developerMessage);
            validationErrorDetails.setTitulo(titulo);
            validationErrorDetails.setStatus(status);
            validationErrorDetails.setDetalhes(detalhes);
            validationErrorDetails.setTimestamp(timestamp);
            validationErrorDetails.field = field;
            validationErrorDetails.fielMessage = fielMessage;
            return validationErrorDetails;
        }
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFielMessage() {
        return fielMessage;
    }

    public void setFielMessage(String fielMessage) {
        this.fielMessage = fielMessage;
    }
}
