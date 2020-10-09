package br.com.devSpringBoot.awesome.error;

public class ResourceNotFoundDetails extends ErrorDetails {

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

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
            resourceNotFoundDetails.setTitulo(titulo);
            resourceNotFoundDetails.setStatus(status);
            resourceNotFoundDetails.setDetalhes(detalhes);
            resourceNotFoundDetails.setTimestamp(timestamp);
            return resourceNotFoundDetails;
        }
    }
}
