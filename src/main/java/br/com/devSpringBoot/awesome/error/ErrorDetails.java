package br.com.devSpringBoot.awesome.error;

public class ErrorDetails {

    private String titulo;
    private int status;
    private String detalhes;
    private long timestamp;
    private String developerMessage;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public static final class Builder {
        private String titulo;
        private int status;
        private String detalhes;
        private long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
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

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitulo(titulo);
            errorDetails.setStatus(status);
            errorDetails.setDetalhes(detalhes);
            errorDetails.setTimestamp(timestamp);
            errorDetails.setDeveloperMessage(developerMessage);
            return errorDetails;
        }
    }
}
