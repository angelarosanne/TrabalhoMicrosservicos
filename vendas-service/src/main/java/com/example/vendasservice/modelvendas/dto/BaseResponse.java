package com.example.vendasservice.modelvendas.dto;

public record BaseResponse(String[] erroMensagem) {
    

    public boolean hasErrors(){
        return erroMensagem != null && erroMensagem.length > 0;
    }
}
