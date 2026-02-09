package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos()
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros()
    {
    	int size = this.arregloEnteros.length;
    	int [] copia = new int[size];
    	// Copia el arreglo original en copia
    	for (int i = 0; i < size; i ++)
    		copia[i] = this.arregloEnteros[i];
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas()
    {
    	
    	int size = this.arregloCadenas.length;
    	String [] copia = new String[size];
    	// Copia el arreglo original en copia
    	for (int i = 0; i < size; i ++)
    		copia[i] = this.arregloCadenas[i];
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int size = this.arregloEnteros.length;
    	int n_size = size + 1;
    	int [] nuevo = new int[n_size];
    	// Copia todo en un arreglo mas grande por 1 elemento
    	for (int i = 0; i < size; i ++)
    		nuevo[i] = this.arregloEnteros[i];
    	// Mete al final el entero a insertar
    	nuevo[size] = entero;
    	this.arregloEnteros =  nuevo;		
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int size = this.arregloCadenas.length;
    	int n_size = size + 1;
    	String [] nuevo = new String[n_size];
    	// Copia todo en un arreglo mas grande por 1 elemento
    	for (int i = 0; i < size; i ++)
    		nuevo[i] = this.arregloCadenas[i];
    	// Mete al final la cadena a insertar
    	nuevo[size] = cadena;
    	this.arregloCadenas =  nuevo;	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int size = this.arregloEnteros.length;
    	// Cuenta las apariciones de la cadena a eliminar para saber el size del nuevo arreglo
    	int apariciones = contarApariciones(valor);
    	int n_size = size - apariciones;
    	int [] temporal = new int[n_size];
    	// Copia en el nuevo arreglo solo los elementos que sean distintos al elemento a borrar
    	for (int i = 0; i < size; i++)
    		if (this.arregloEnteros[i] != valor && i < n_size)
    			temporal[i] = this.arregloEnteros[i];
    	this.arregloEnteros = temporal;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int size = this.arregloCadenas.length;
    	// Cuenta las apariciones de la cadena a eliminar para saber el size del nuevo arreglo
    	int apariciones = contarApariciones(cadena);
    	int n_size = size - apariciones;
    	String [] temporal = new String[n_size];
    	// Copia en el nuevo arreglo solo los elementos que sean distintos al elemento a borrar
    	for (int i = 0; i < size; i++)
    		if (this.arregloCadenas[i] != cadena && i < n_size)
    			temporal[i] = this.arregloCadenas[i];
    	this.arregloCadenas = temporal;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int size = this.arregloEnteros.length;
    	int n_size = size + 1;
    	int [] temporal = new int[n_size];
    	// Caso de que se inserte en primera posicion
    	if (posicion < 0) {
    		temporal[0] = entero;
    		for (int i = 1; i < n_size; i ++) {
    			temporal[i] =  this.arregloEnteros[i - 1];
    		}
    	}
    	// Caso de que se inserte en la ultima posicion
    	else if (posicion > this.arregloEnteros.length) {
    		agregarEntero(entero);
    		return;
    	}
    	else
    		// Caso de que se inserte en alguna posicion intermedia
    		for (int i = 0; i < n_size; i ++) {
    			// Copia normal hasta la posicion a insertar
    			if (i < posicion) {
    				temporal[i] = this.arregloEnteros[i]; 			
    			}
    			// Inserta en la posicion
    			else if (i == posicion) 
    				temporal[i] = entero;
    			// Desplaza los elementos restantes una posición a la derecha para compensar la inserción
    			else
    				temporal[i] = this.arregloEnteros[i - 1];
    		}	
    	this.arregloEnteros = temporal;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {  	
    	int size = this.arregloEnteros.length;
    	int n_size = size - 1;
    	int temporal[] = new int [n_size];
    	// Verificacion de que la posicion este en el arreglo
    	if (posicion < 0 || size <= posicion)
    		return;
    	int indice = 0;
    	// Se copia el arreglo entero a uno nuevo excepto la posicion que se indica
    	for (int i = 0; i < size; i++)
    		if (i != posicion) {
    			temporal[indice] = this.arregloEnteros[i];
    			indice ++;
    		}
    	this.arregloEnteros = temporal;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int size = valores.length;
    	int[] nuevo = new int [size];
    	// Casting de double a int
    	for (int i = 0; i < size; i++)
    		nuevo[i] = (int) valores[i];
    	this.arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	
    	int size = objetos.length;
    	String[] nuevo = new String [size];
    	// Convierte cada object en string con .toString()
    	for (int i = 0; i < size; i++)
    		nuevo[i] = objetos[i].toString();
    	this.arregloCadenas = nuevo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int size = this.arregloEnteros.length;
    	// Si el valor es negativo se multiplica por menos 1
    	for (int i = 0; i < size; i++)
    		if (this.arregloEnteros[i] < 0)
    			this.arregloEnteros[i] = this.arregloEnteros[i] * -1;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	{
    		// Selection sort
            for(int i = 0; i < this.arregloEnteros.length - 1; i++)
            {
                for(int j = i + 1; j < this.arregloEnteros.length; j++)
                {
                    if(this.arregloEnteros[i] > this.arregloEnteros[j])
                    {
                        int temporal = this.arregloEnteros[i];
                        this.arregloEnteros[i] = this.arregloEnteros[j];
                        this.arregloEnteros[j] = temporal;
                    }
                }
            }
    	}

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	{
    		// Selection sort
            for(int i = 0; i < this.arregloCadenas.length - 1; i++)
            {
                for(int j = i + 1; j < this.arregloCadenas.length; j++)
                {
                    if(this.arregloCadenas[i].compareTo(arregloCadenas[j])> 0)
                    {
                        String temporal = this.arregloCadenas[i];
                        this.arregloCadenas[i] = this.arregloCadenas[j];
                        this.arregloCadenas[j] = temporal;
                    }
                }
            }
    	}

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int size = this.arregloEnteros.length;
        int contador = 0;
        // El bucle verifica cuantas veces se repite el valor
        for (int i = 0; i < size; i++)
        	if (this.arregloEnteros[i] == valor)
        		contador++;
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	
    	int size = this.arregloCadenas.length;
        int contador = 0;
        // Cuenta las apariciones del caracter ignorando si es mayuscula o miniscula (para eso el .toLowerCase())
        for (int i = 0; i < size; i++)
        	if (this.arregloCadenas[i].toLowerCase().equals(cadena.toLowerCase()))
        		contador++;
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	
    	int size = this.arregloEnteros.length;
        int o_size = contarApariciones(valor);
        int resultado[] = new int[o_size];
        int indice = 0;
        // Compara cual posicion es la que tiene el valor a buscar y si es asi se almacena en el arreglo resultado
        for (int i = 0; i < size; i++)
        	if (this.arregloEnteros[i] == valor) {
        		resultado[indice] = i;
        		indice ++;
        	}
        return resultado;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {	
    	
    	int size = this.arregloEnteros.length;
    	// La pos 0 es el menor y la pos 1 es la mayor
    	int resultado[] = new int[2];
    	if (size == 0) {
    		int vacio[] = new int[0];
    		return vacio;
    	}
    	// Se compara si el valor es menor o mayor al limite inferior o superior respectivamente
    	for (int i = 0; i < size; i++)
    		if (this.arregloEnteros[i] < resultado[0]) {
    			resultado[0] = this.arregloEnteros[i];
    		}
    		else if ( this.arregloEnteros[i] > resultado[1])
    			resultado[1] = this.arregloEnteros[i];
        return resultado;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	
    	HashMap<Integer, Integer> resultado = new HashMap<>();
    	int size = this.arregloEnteros.length;
    	// Si esta sumamos uno al valor en el mapa, si no se inserta con valor 1
    	for (int i = 0; i < size; i++)
    		if (resultado.containsKey(this.arregloEnteros[i])) {
    			int num = resultado.get(this.arregloEnteros[i]) + 1;
    			resultado.put(this.arregloEnteros[i], num);
    		}
    		else
    			resultado.put(this.arregloEnteros[i], 1);
        return resultado;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	// Se cuentan las repeticiones segun el resultado del metodo calcular histograma
    	int contador = 0;
        HashMap<Integer, Integer> histograma = calcularHistograma();
        // Al ser un mapa histograma tiene el metodo .values que se usa para iterar en el for each
        for (int frecuencia : histograma.values()) {
            if (frecuencia > 1) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	// Se comparan posicion por posicion puesto que deberian ser iguales con respecto al orden
    	if (otroArreglo.length != this.arregloEnteros.length)
    		return false;
    	int size = this.arregloEnteros.length;
    	for (int i = 0; i < size; i++)
    		if (this.arregloEnteros[i] != otroArreglo[i])
    			return false;
        return true;
        
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	//Se copian ambos arreglos para ordenarlos y comparar, se usa .clone ya que otroArreglo no es instancia de sandbox arreglos lo que impide llamar al metodo copiaEnteros
    	if (this.arregloEnteros.length != otroArreglo.length)
    		return false;
    	int[] copiaog = getCopiaEnteros();
    	int[] copiaOtro = otroArreglo.clone();
    	// Ordenamiento del primer arreglo, puesto que no son instancias de sanboxArreglos el ordenamiento se hace manual y no mediante el metodo organizarEnteros
    	for(int i = 0; i < copiaog.length - 1; i++)
        {
            for(int j = i + 1; j < copiaog.length; j++)
            {
                if(copiaog[i] > copiaog[j])
                {
                    int temporal = copiaog[i];
                    copiaog[i] = copiaog[j];
                    copiaog[j] = temporal;
                }
            }
        }
    	// Ordenamiento del segundo arreglo, puesto que no son instancias de sanboxArreglos el ordenamiento se hace manual y no mediante el metodo organizarEnteros
    	for(int i = 0; i < copiaOtro.length - 1; i++)
        {
            for(int j = i + 1; j < copiaOtro.length; j++)
            {
                if(copiaOtro[i] > copiaOtro[j])
                {
                    int temporal = copiaOtro[i];
                    copiaOtro[i] = copiaOtro[j];
                    copiaOtro[j] = temporal;
                }
            }
        }
    	// Comparacion de ambos arreglos ordenados
    	int size = this.arregloEnteros.length;
    	for (int i = 0; i < size; i++)
    		if (copiaog[i] != copiaOtro[i])
    			return false;
        return true;
    	    
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        this.arregloEnteros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int random = (int)(Math.random() * (maximo - minimo + 1)) + minimo;
            this.arregloEnteros[i] = random;
        }
    }

}
