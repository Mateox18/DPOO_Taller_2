package uniandes.dpoo.estructuras.logica;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	// Se retorna ArrayList, el import fue insertado debido a el tipo de retorno requerido.
    	 List<String> lista = new ArrayList<>(mapaCadenas.values());
    	 lista.sort(null); 
    	 return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	// Obtiene el key set.
    	List<String> lista = new ArrayList<>(mapaCadenas.keySet());
	   	lista.sort(null); 
	   	int size = lista.size();
	   	List<String> listainversa = new ArrayList<>();
	   	// Invierte la lista.
	   	for(int i = size - 1; i >= 0; i--) {
    		String x = lista.get(i);
    		listainversa.add(x);
    	}
	   	return listainversa;
        
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if (mapaCadenas.isEmpty())
    		return null;
    	// Convierte a lista los valores, los ordena lexicograficamente y devuelve el primero.
    	List<String> lista = new ArrayList<>(mapaCadenas.values());
   	 	lista.sort(null); 
   	 	return lista.get(0);
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if (mapaCadenas.isEmpty())
    		return null;
    	int size = mapaCadenas.size();
    	// Convierte a lista los valores, los ordena lexicograficamente y devuelve el ultimo.
    	List<String> lista = new ArrayList<>(mapaCadenas.values());
   	 	lista.sort(null); 
   	 	return lista.get(size - 1);
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	// Obtiene la lista de llaves.
    	List<String> listallaves = getLlavesComoListaInvertida();
    	Collection<String> resultado = new ArrayList<>();
    	// Convierte las llaves a mayusculas.
    	for(String llave : listallaves)
    		resultado.add(llave.toUpperCase());
        return resultado;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	// Las llaves y los valores en este caso son todos unicos por lo tanto es el size.
        return mapaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	// Se usa string builder para invertir.
    	String invertida = new StringBuilder(cadena).reverse().toString();
    	// Put inserta o actualiza dependiendo de si la cadena ya existia en el mapa.
    	mapaCadenas.put(invertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	// Si el valor de la llave coincide elimina el elemento asociado a esa llave.
    	for(String key : mapaCadenas.keySet()) {
    		if(mapaCadenas.get(key) == valor)
    			mapaCadenas.remove(key);
    	}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	int size = objetos.size();
    	// Vacia el mapa anterior y mete los nuevos elementos
    	for (int i = 0; i < size; i++) {
    		String original = objetos.get(i).toString();
    		agregarCadena(original);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	if (mapaCadenas.isEmpty())
    		return;
    	HashMap<String, String> copia = new HashMap<>();
    	// Mete en copia las mismas cadenas pero en mayusculas.
    	for(String key : mapaCadenas.keySet()) {
    		String valor = mapaCadenas.get(key);
    		String mayus = key.toUpperCase();
    		copia.put(mayus, valor);
    	}
    	// Actualiza mapaCadenas.
    	mapaCadenas = copia;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        for (String valor : otroArreglo)
        	// Si algun valor no esta false.
        	if (mapaCadenas.containsValue(valor) != true)
        		return false;
        return true;
    }

}
