package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagenation implements Capable{
	private HttpServletRequest request;
	private String pageNum, pageSize, blockSize,
			startRow, endRow, startPage, endPage,
			prevBlock, nextBlock;
	private int totalCount;
	private boolean existPrev, existNext;
	@Override
	public void carryOut() {
		HttpServletRequest request = Receiver.cmd.getRequest();
		String pageNum = request.getParameter("page_num");
		this.pageNum = (pageNum==null)? "1" : pageNum;
		String pageSize = request.getParameter("page_size");
		this.pageSize = (pageSize==null) ? "5" : pageSize ;
		System.out.println(":::페이지 넘:::"+this.pageNum+":::::페이지 사이ㅈㅡ:::::"+this.pageSize);
		this.totalCount = CustomerServiceImpl.getInstance().countCustomer();
		this.startRow = (totalCount - Integer.parseInt(this.pageSize))+"";
		this.endRow = (Integer.parseInt(this.startRow) + 5)+"";
		System.out.println("토탈::::::"+totalCount+"::::스타트::::"+startRow+":::엔드:::"+endRow);
	}

}