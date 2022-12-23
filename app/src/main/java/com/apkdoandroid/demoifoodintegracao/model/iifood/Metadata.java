package com.apkdoandroid.demoifoodintegracao.model.iifood;

import com.google.gson.annotations.SerializedName;

public class Metadata {
    @SerializedName("CANCEL_STAGE")
    private String cancelarEstagio;
    @SerializedName("workerPhone")
    private String telefoneEntregador;
    @SerializedName("workerVehicleType")
    private String veiiculoEntregador;
    @SerializedName("workerName")
    private String nomeEntregador;
    @SerializedName("workerExternalUuid")
    private String idEntregador;
    @SerializedName("ORIGIN")
    private String origem;
    @SerializedName("CANCEL_CODE")
    private String codigoDeCancelamento;
    @SerializedName("TIMEOUT_EVENT")
    private String tempoEsgotadoDoEvento;
    @SerializedName("CANCEL_ORIGIN")
    private String origemDoCancelamento;
    @SerializedName("CANCEL_USER")
    private String cancelarUsuario;
    @SerializedName("CANCEL_REASON")
    private String motivoDoCancelamento;
    @SerializedName("CANCELLATION_REQUESTED_EVENT_ID")
    private String idDoEnventoSolicitadoDeCancelamento;


    @Override
    public String toString() {
        return "Metadata{" +
                "cancelarEstagio='" + cancelarEstagio + '\'' +
                ", telefoneEntregador='" + telefoneEntregador + '\'' +
                ", veiiculoEntregador='" + veiiculoEntregador + '\'' +
                ", nomeEntregador='" + nomeEntregador + '\'' +
                ", idEntregador='" + idEntregador + '\'' +
                ", origem='" + origem + '\'' +
                ", codigoDeCancelamento='" + codigoDeCancelamento + '\'' +
                ", tempoEsgotadoDoEvento='" + tempoEsgotadoDoEvento + '\'' +
                ", origemDoCancelamento='" + origemDoCancelamento + '\'' +
                ", cancelarUsuario='" + cancelarUsuario + '\'' +
                ", motivoDoCancelamento='" + motivoDoCancelamento + '\'' +
                ", idDoEnventoSolicitadoDeCancelamento='" + idDoEnventoSolicitadoDeCancelamento + '\'' +
                '}';
    }

    public String getTelefoneEntregador() {
        return telefoneEntregador;
    }

    public void setTelefoneEntregador(String telefoneEntregador) {
        this.telefoneEntregador = telefoneEntregador;
    }

    public String getVeiiculoEntregador() {
        return veiiculoEntregador;
    }

    public void setVeiiculoEntregador(String veiiculoEntregador) {
        this.veiiculoEntregador = veiiculoEntregador;
    }

    public String getNomeEntregador() {
        return nomeEntregador;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public String getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(String idEntregador) {
        this.idEntregador = idEntregador;
    }

    public String getCancelarEstagio() {
        return cancelarEstagio;
    }

    public void setCancelarEstagio(String cancelarEstagio) {
        this.cancelarEstagio = cancelarEstagio;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getCodigoDeCancelamento() {
        return codigoDeCancelamento;
    }

    public void setCodigoDeCancelamento(String codigoDeCancelamento) {
        this.codigoDeCancelamento = codigoDeCancelamento;
    }

    public String getTempoEsgotadoDoEvento() {
        return tempoEsgotadoDoEvento;
    }

    public void setTempoEsgotadoDoEvento(String tempoEsgotadoDoEvento) {
        this.tempoEsgotadoDoEvento = tempoEsgotadoDoEvento;
    }

    public String getOrigemDoCancelamento() {
        return origemDoCancelamento;
    }

    public void setOrigemDoCancelamento(String origemDoCancelamento) {
        this.origemDoCancelamento = origemDoCancelamento;
    }

    public String getCancelarUsuario() {
        return cancelarUsuario;
    }

    public void setCancelarUsuario(String cancelarUsuario) {
        this.cancelarUsuario = cancelarUsuario;
    }

    public String getMotivoDoCancelamento() {
        return motivoDoCancelamento;
    }

    public void setMotivoDoCancelamento(String motivoDoCancelamento) {
        this.motivoDoCancelamento = motivoDoCancelamento;
    }

    public String getIdDoEnventoSolicitadoDeCancelamento() {
        return idDoEnventoSolicitadoDeCancelamento;
    }

    public void setIdDoEnventoSolicitadoDeCancelamento(String idDoEnventoSolicitadoDeCancelamento) {
        this.idDoEnventoSolicitadoDeCancelamento = idDoEnventoSolicitadoDeCancelamento;
    }
}
