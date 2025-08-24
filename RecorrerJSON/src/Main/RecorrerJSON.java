

public class RecorrerJSON {

	public static void main(String[] args) {
		 String jsonString = "{\n" +
		            "  \"empresa\": \"GlobalTech\",\n" +
		            "  \"fundada\": 2005,\n" +
		            "  \"sectores\": [\n" +
		            "    {\n" +
		            "      \"nombre\": \"Desarrollo de Software\",\n" +
		            "      \"proyectos\": [\n" +
		            "        {\n" +
		            "          \"nombre\": \"Plataforma E-Commerce\",\n" +
		            "          \"tecnologias\": [\n" +
		            "            \"Java\",\n" +
		            "            \"Spring Boot\",\n" +
		            "            \"React\"\n" +
		            "          ],\n" +
		            "          \"equipo\": [\n" +
		            "            {\n" +
		            "              \"nombre\": \"Carlos\",\n" +
		            "              \"rol\": \"Líder de proyecto\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "              \"nombre\": \"María\",\n" +
		            "              \"rol\": \"Desarrolladora Backend\"\n" +
		            "            },\n" +
		            "            {\n" +
		            "              \"nombre\": \"José\",\n" +
		            "              \"rol\": \"Desarrollador Frontend\"\n" +
		            "            }\n" +
		            "          ]\n" +
		            "        }\n" +
		            "      ]\n" +
		            "    }\n" +
		            "  ]\n" +
		            "}";

		        // Parseo el JSON
		        JSONObject jsonObject = new JSONObject(jsonString);

		        // Aquí llamas a tu función recursiva
		        recorrerJSON(jsonObject, "");
		    }
	
	 public static void recorrerJSON(Object obj, String indent) {
	        if (obj instanceof JSONObject) {
	            // Si es un JSONObject, recursivamente imprimimos los valores
	            JSONObject jsonObject = (JSONObject) obj;
	            for (String key : jsonObject.keySet()) {
	                System.out.println(indent + key + ":");
	                recorrerJSON(jsonObject.get(key), indent + "  ");
	            }
	        } else if (obj instanceof JSONArray) {
	            // Si es un JSONArray, recorremos sus elementos
	            JSONArray jsonArray = (JSONArray) obj;
	            for (int i = 0; i < jsonArray.length(); i++) {
	                System.out.println(indent + "Elemento " + (i + 1) + ":");
	                recorrerJSON(jsonArray.get(i), indent + "  ");
	            }
	        } else {
	            // Si es un valor primitivo, lo imprimimos
	            System.out.println(indent + obj.toString());
	        }
	    }

}
