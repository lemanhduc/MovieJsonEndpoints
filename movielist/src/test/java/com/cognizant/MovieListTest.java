package com.cognizant;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.is;


import org.springframework.http.MediaType;

@WebMvcTest(MovieListController.class)
public class MovieListTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testEndpoint_Should_Return_JsonString() throws Exception{

        RequestBuilder req = get("/movies/movie")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk());

    }

    @Test
    public void testCalculateGrossTotal() throws Exception {
        String requestStr ="[\n" +
                "      {\n" +
                "        \"Title\": \"The Godfather\",\n" +
                "        \"Minutes\": 175,\n" +
                "        \"Genre\": \"Crime, Drama\",\n" +
                "        \"Rating\": 9.2,\n" +
                "        \"MetaScore\": 100,\n" +
                "        \"Description\": \"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.\",\n" +
                "        \"Votes\": 1561591,\n" +
                "        \"Gross\": 134.97,\n" +
                "        \"Year\": \"1972\",\n" +
                "        \"Credits\": [\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Director\",\n" +
                "                    \"FirstName\": \"Francis Ford\",\n" +
                "                    \"LastName\": \"Copolla\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Marlon\",\n" +
                "                    \"LastName\": \"Brando\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Al\",\n" +
                "                    \"LastName\": \"Pacino\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"James\",\n" +
                "                    \"LastName\": \"Caan\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Diane\",\n" +
                "                    \"LastName\": \"Keaton\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"Title\": \"The Godfather: Part II\",\n" +
                "        \"Minutes\": 202,\n" +
                "        \"Genre\": \"Crime, Drama\",\n" +
                "        \"Rating\": 9,\n" +
                "        \"MetaScore\": 90,\n" +
                "        \"Description\": \"The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.\",\n" +
                "        \"Votes\": 1091420,\n" +
                "        \"Gross\": 57.30,\n" +
                "        \"Year\": \"1974\",\n" +
                "        \"Credits\": [\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Director\",\n" +
                "                    \"FirstName\": \"Francis Ford\",\n" +
                "                    \"LastName\": \"Copolla\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Al\",\n" +
                "                    \"LastName\": \"Pacino\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Robert\",\n" +
                "                    \"LastName\": \"De Niro\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Robert\",\n" +
                "                    \"LastName\": \"Duvall\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"Person\": {\n" +
                "                    \"Role\": \"Star\",\n" +
                "                    \"FirstName\": \"Diane\",\n" +
                "                    \"LastName\": \"Keaton\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        //  ObjectMapper mapper = new ObjectMapper();
        RequestBuilder requestBuilder = post("/movies/gross/total")
                .content(requestStr)
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(requestBuilder)
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.Result", is(191)));


    }
}
