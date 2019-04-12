package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoardsIncludeMapToList() {

        //Given
        TrelloListDto tl1 = new TrelloListDto("1", "TL1", false);
        List<TrelloListDto> list = new ArrayList<>();
        list.add(tl1);

        TrelloBoardDto tb1 = new TrelloBoardDto("1", "tb1", list);
        List<TrelloBoardDto> boardsDto = new ArrayList<>();
        boardsDto.add(tb1);

        System.out.println(boardsDto.size());

        //When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(boardsDto);
        int size = boards.size();

        //Then
        Assert.assertEquals(1, size);

    }

    @Test
    public void testMapToBoardsDtoIncludeMapToListDto() {

        //Given
        TrelloList tl1 = new TrelloList("1", "Done", false);
        TrelloList tl2 = new TrelloList("2", "To do", false);
        TrelloList tl3 = new TrelloList("3", "In Progress", false);

        List<TrelloList> list = new ArrayList<>();
        list.add(tl1);
        list.add(tl2);
        list.add(tl3);

        TrelloBoard tb1 = new TrelloBoard("1", "Work Board", list);
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(tb1);

        //When
        List<TrelloBoardDto> boardsDto = trelloMapper.mapToBoardsDto(boards);
        long listSize = boardsDto.stream()
                .flatMap(b -> b.getLists().stream())
                .count();

        //Then
        Assert.assertEquals(3, listSize);
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("Task", "Something to do", "1", "1");
        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);
        String descriptionCard = card.getDescription();
        String descriptionCardDto = cardDto.getDescription();
        //Then
        Assert.assertEquals(descriptionCard, descriptionCardDto);
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("Task", "Send mail", "2", "1");
        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);
        String descriptionCard = card.getName();
        String descriptionCardDto = cardDto.getName();
        //Then
        Assert.assertEquals(descriptionCard, descriptionCardDto);
    }
}