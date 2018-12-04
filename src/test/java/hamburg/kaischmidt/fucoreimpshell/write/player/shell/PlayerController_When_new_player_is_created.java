package hamburg.kaischmidt.fucoreimpshell.write.player.shell;

import hamburg.kaischmidt.fucoreimpshell.events.core.PlayerCreatedEvent;
import hamburg.kaischmidt.fucoreimpshell.events.shell.EventStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerController_When_new_player_is_created {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventStore store;

    @Test
    public void Then_call_is_redirected_And_event_is_created() throws Exception {

        //Arrange
        String newPlayer = "Test";
        assertThat(store.getEvents()).isEmpty();

        //Act
        mockMvc.perform(post("/command/create-player").contentType(APPLICATION_FORM_URLENCODED_VALUE).content("Spielername=" + newPlayer).accept(APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        //Assert
        assertThat(store.getEvents().size()).isEqualTo(1);
        PlayerCreatedEvent createdEvent = (PlayerCreatedEvent) store.getEvents().get(0).getDomainEvent();
        assertThat(createdEvent.getPlayerName()).isEqualTo(newPlayer);

        //TODO KSC 2.12.2018: Sobald Spielerübersicht besteht, über die zugehörige get-url testen, dass der neue Spieler angezeigt wird
    }

}