 
public class teste20 {

  
    public static final int TAMANHO_VETOR = 11;

    public static void main(String[] args) {

        teste20 bubbleSort = new teste20();
 
        int[] vetor = new int[TAMANHO_VETOR];
 
              for (int i = 0; i < vetor.length; i++) {
 
            vetor[i] = (int) (Math.random() * 100);
 
        }
 
        bubbleSort.exibeVetor(vetor);
 
        bubbleSort.ordenaBubbleSort(vetor);
 
        bubbleSort.exibeVetor(vetor);
 
 
    }
 
    private void ordenaBubbleSort(int[] v) {
 
        for (int i = 0; i < v.length; i++) {
 
         
            if (i != v.length - 1) {
 
              
                if (!(v[i] <= v[i + 1])) {
 
                    int valorTemp = v[i];
 
                  
                    v[i] = v[i + 1];
 
                   
                    v[i + 1] = valorTemp;
                }
            }
        }
 
        if (!isVetorOrdenado(v)) {
 
            ordenaBubbleSort(v);
 
        }
    }
 
  
    private boolean isVetorOrdenado(int[] v) {
 
        for (int i = 0; i < v.length; i++) {
           
            if (i != v.length - 1) {
              
                if (!(v[i] <= v[i + 1])) {
 
                    return false;
 
                }
            }
 
        }
        return true;
    }
   
    private void exibeVetor(int[] v) {
 
        System.out.println("\n");
 
        for (int i = 0; i < v.length; i++) {
 
            System.out.print(v[i] + " ");
 
        }
    }
}