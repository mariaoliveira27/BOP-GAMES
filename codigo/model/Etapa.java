package codigo.model;

        public abstract class Etapa {
            private static int etapa = 21;
            private Duracao duracao;
            private Data data;
            private Hora horaInicial;
        
            public Duracao getDuracao() {
                return duracao;
            }
            public Etapa(int numero, Data data, Hora horaInicial, Duracao duracao){
                this.data = data;
                this.duracao = duracao;
                this.numero = numero;
                this.horaInicial = horaInicial;
        
            }
            public int getNumero(){
                return numero;
            }
            public int getDuracaoEmSegundos(){
                return getDuracaoEmSegundos();
            }
            @Override
            public String toString(){
                return String.format("Etapa %d: Data %s, Hora Inicial %s, Duração: %s segundos", 
                numero, data, horaInicial, getDuracaoEmSegundos());           
             }
        }
            