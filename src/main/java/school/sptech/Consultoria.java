package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double soma = 0.0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            soma += desenvolvedores.get(i).calcularSalario();
        }

        return soma;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer devMobile = 0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {
                devMobile++;
            }
        }

        return devMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resposta = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() >= salario) {
                resposta.add(desenvolvedores.get(i));
            }
        }

        return resposta;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        List<Desenvolvedor> resposta = new ArrayList<>();
        Double menor = 0.0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() < menor || i == 0) {
                menor = desenvolvedores.get(i).calcularSalario();
                resposta.add(desenvolvedores.get(i));
            }
        }

        Integer tamanhoLista = resposta.size();
        return resposta.get(tamanhoLista - 1);
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resposta = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorWeb) {

                if (((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)) {
                    resposta.add(desenvolvedores.get(i));
                }

            } else if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {

                if (((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)) {
                    resposta.add(desenvolvedores.get(i));
                }

            }
        }

        return resposta;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorWeb) {

                if (((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)) {
                    soma += desenvolvedores.get(i).calcularSalario();
                }

            } else if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {

                if (((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)) {
                    soma += desenvolvedores.get(i).calcularSalario();
                }

            }
        }

        return soma;
    }
}
