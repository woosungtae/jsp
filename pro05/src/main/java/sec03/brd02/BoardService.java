package sec03.brd02;
 
import java.util.List;
 
public class BoardService { // BoardDAO 객체를 생성한후 select...()메서드로 전체글 가져옴
    BoardDAO boardDAO;
    public BoardService() {
        boardDAO = new BoardDAO(); // 생성자 호출시 BoardDAO 객체를 생성
    }
    public List<ArticleVO> listArticles(){
        List<ArticleVO> articlesList = boardDAO.selectAllArticles();
        return articlesList;
    }
    public void addArticle(ArticleVO article) {
       boardDAO.insertNewArticle(article);
    }
}