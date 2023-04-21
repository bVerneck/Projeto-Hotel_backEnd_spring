package br.com.tex.hotel.model.dto.validCampos;

import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OutputValidCamposDTO {

    private String campo;
    private String mensagem;

    public OutputValidCamposDTO(FieldError error) {
        this.campo = error.getField();
        this.mensagem = error.getDefaultMessage();
    }

    public List<OutputValidCamposDTO> lista(List<FieldError> erros) {
        return erros
                .stream()
                .map(e -> new OutputValidCamposDTO(e))
                .toList();
    }
}
