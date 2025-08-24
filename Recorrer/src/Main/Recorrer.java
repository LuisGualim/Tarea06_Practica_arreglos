package Main;

import org.json.JSONObject;

import java.util.Iterator;

import org.json.JSONArray;

public class Recorrer {

    public static void recorrerJSON(Object obj, String indent) {
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(indent + key + ":");
                recorrerJSON(jsonObject.get(key), indent + "  "); // Recursividad para los valores
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.length(); i++) {
                recorrerJSON(jsonArray.get(i), indent + "  "); // Recursividad para cada elemento del array
            }
        } else {
            System.out.println(indent + obj.toString());
        }
    }

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
            "        },\n" +
            "        {\n" +
            "          \"nombre\": \"App Móvil Salud\",\n" +
            "          \"tecnologias\": [\n" +
            "            \"Kotlin\",\n" +
            "            \"Firebase\",\n" +
            "            \"ML Kit\"\n" +
            "          ],\n" +
            "          \"equipo\": [\n" +
            "            {\n" +
            "              \"nombre\": \"Andrea\",\n" +
            "              \"rol\": \"Scrum Master\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"nombre\": \"Diego\",\n" +
            "              \"rol\": \"Desarrollador Android\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"nombre\": \"Ciberseguridad\",\n" +
            "      \"servicios\": [\n" +
            "        {\n" +
            "          \"tipo\": \"Pentesting\",\n" +
            "          \"clientes\": [\n" +
            "            {\n" +
            "              \"nombre\": \"Banco Uno\",\n" +
            "              \"pais\": \"Guatemala\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"nombre\": \"Banco Dos\",\n" +
            "              \"pais\": \"El Salvador\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"tipo\": \"Monitoreo 24/7\",\n" +
            "          \"herramientas\": [\n" +
            "            \"SIEM\",\n" +
            "            \"Snort\",\n" +
            "            \"Wireshark\"\n" +
            "          ],\n" +
            "          \"turnos\": {\n" +
            "            \"mañana\": [\n" +
            "              \"Luis\",\n" +
            "              \"Camila\"\n" +
            "            ],\n" +
            "            \"tarde\": [\n" +
            "              \"Roberto\",\n" +
            "              \"Elena\"\n" +
            "            ],\n" +
            "            \"noche\": [\n" +
            "              \"Sofía\"\n" +
            "            ]\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"sucursales\": {\n" +
            "    \"Guatemala\": {\n" +
            "      \"direccion\": \"Zona 10, Ciudad de Guatemala\",\n" +
            "      \"departamentos\": {\n" +
            "        \"RRHH\": {\n" +
            "          \"jefe\": \"Laura\",\n" +
            "          \"empleados\": [\n" +
            "            \"Pedro\",\n" +
            "            \"Ana\",\n" +
            "            \"Carlos\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"Finanzas\": {\n" +
            "          \"jefe\": \"Fernando\",\n" +
            "          \"empleados\": [\n" +
            "            \"Marta\",\n" +
            "            \"Juan\"\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"México\": {\n" +
            "      \"direccion\": \"CDMX, Reforma\",\n" +
            "      \"departamentos\": {\n" +
            "        \"Marketing\": {\n" +
            "          \"jefe\": \"Valeria\",\n" +
            "          \"campañas\": [\n" +
            "            {\n" +
            "              \"nombre\": \"Campaña 2024\",\n" +
            "              \"canales\": [\n" +
            "                \"TV\",\n" +
            "                \"Radio\",\n" +
            "                \"Redes Sociales\"\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"nombre\": \"Campaña 2025\",\n" +
            "              \"canales\": [\n" +
            "                \"Digital Ads\",\n" +
            "                \"SEO\"\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"certificaciones\": [\n" +
            "    {\n" +
            "      \"nombre\": \"ISO 27001\",\n" +
            "      \"año\": 2021\n" +
            "    },\n" +
            "    {\n" +
            "      \"nombre\": \"ISO 9001\",\n" +
            "      \"año\": 2020\n" +
            "    }\n" +
            "  ],\n" +
            "  \"contacto\": {\n" +
            "    \"telefonos\": [\n" +
            "      \"+502-5555-1111\",\n" +
            "      \"+502-5555-2222\"\n" +
            "    ],\n" +
            "    \"emails\": {\n" +
            "      \"soporte\": \"soporte@globaltech.com\",\n" +
            "      \"ventas\": \"ventas@globaltech.com\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

        // Convertir el JSON en un objeto JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Llamar al método recursivo para recorrer el JSON
        recorrerJSON(jsonObject, "");
    }
}
