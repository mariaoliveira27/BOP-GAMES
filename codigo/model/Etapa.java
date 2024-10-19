package codigo.model;

        public abstract class Etapa {
            private static int ETAPAS;
            private Duracao duracao;
            private Data data;
            private Hora horaInicial;
            private int numero;
        
            
            public Etapa(int numero, Data data, Hora horaInicial, Duracao duracao){
                this.data = data;
                this.duracao = duracao;
                this.numero = numero;
                this.horaInicial = horaInicial;
        
            }

            public Duracao getDuracao() {
                return duracao;
            }
            public int getNumero(){
                return numero;
            }
            public int getDuracaoEmSegundos(){
                return duracao.getTotalSegundos();
            }
            
            @Override
            public String toString(){
                return String.format("Etapa %d: Data %s, Hora Inicial %s, Duração: %s segundos, Número: %d", numero,  data, horaInicial, getDuracaoEmSegundos());           
             }
        }
            