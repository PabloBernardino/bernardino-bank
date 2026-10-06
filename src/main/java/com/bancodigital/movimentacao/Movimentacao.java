package com.bancodigital.movimentacao;

import com.bancodigital.Conta.Conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimentacao {

    private TipoTransacao tipoTransacao;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private Conta contaOrigem;
    private Conta contaDestinatario;

    public TipoTransacao getTipoTransacao() {return tipoTransacao;}

    public Movimentacao(TipoTransacao tipoTransacaoInit, BigDecimal valorInit,
                        LocalDateTime dataHoraInit, Conta contaOrigemInit, Conta contaDestinatarioInit) {

        tipoTransacao = tipoTransacaoInit;
        valor = valorInit;
        dataHora = dataHoraInit;
        contaOrigem = contaOrigemInit;
        contaDestinatario = contaDestinatarioInit;
    }

}
