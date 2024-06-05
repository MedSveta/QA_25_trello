package dto;

import interfaces.Path;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@Getter
@Setter
@ToString
@Builder
public class BoardDTO implements Serializable, Path {
    private static final long serialVersionUID = 64565461L;

    private  String boardTitle;
    //transient  private String deleteValue;
    public static void main(String[] args) {
        BoardDTO boardDTO =BoardDTO.builder()
        //.deleteValue("delete")
        .boardTitle("ser1235").build();
       // serializableBoardDTO(boardDTO, "ser1235");
       // System.out.println(deserializableBoardDTO("ser1235").toString());
    }

    public static void serializableBoardDTO(BoardDTO board, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SERIALIZE_PATH + fileName));) {
            outputStream.writeObject(board);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     public static BoardDTO deserializableBoardDTO(String fileName){
         try( ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SERIALIZE_PATH+fileName));) {
             return (BoardDTO) inputStream.readObject();
         } catch (IOException|ClassNotFoundException e) {
             System.out.println("deserializable exception was thrown");
             e.printStackTrace();
             return null;
         }
     }

}
