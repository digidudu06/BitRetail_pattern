package proxy;


import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	private int rowCount, pageNum, pageSize, blockSize,
			startRow, endRow, startPage, endPage,
			prevBlock, nextBlock;
	private boolean existPrev, existNext;
	@Override
	public void carryOut(Object o) {
		HttpServletRequest request = (HttpServletRequest) o;
		String _pageNum = request.getParameter("page_num");
		System.out.println("1........:::페이지 넘:::"+pageNum);
		this.pageNum = (_pageNum==null)? 1 : Integer.parseInt(_pageNum);
		String _pageSize = request.getParameter("page_size");
		this.pageSize = (_pageSize==null) ? 5 : Integer.parseInt(_pageSize);
		System.out.println("2........:::페이지 넘:::"+this.pageNum+":::::페이지 사이ㅈㅡ:::::"+this.pageSize);
		
		String _blockSize = request.getParameter("block_size");
		this.blockSize = (_blockSize==null) ? 5 : Integer.parseInt(_blockSize);
		
		this.rowCount = CustomerServiceImpl.getInstance().countCustomer(null);
		System.out.println("전체 카운트"+this.rowCount);
		
		/*this.endRow = rowCount - (Integer.parseInt(this.pageSize)*(Integer.parseInt(this.pageNum)-1)) +"";
		this.startRow = Integer.parseInt(this.endRow) - (Integer.parseInt(this.pageSize)-1) +"";
        this.startRow = (Integer.parseInt(this.startRow) <= 0) ? this.startRow = "1" : this.startRow ;*/
		startRow = (pageNum-1) * pageSize +1;
		endRow = (startRow + (pageSize-1) < rowCount)? startRow + (pageSize-1) : rowCount ;
		
		System.out.println("토탈::::::"+rowCount+"::::스타트::::"+startRow+":::엔드:::"+endRow);
		
		int blockNum = 0;
		blockNum = (pageNum-1)/blockSize;
		
		startPage = blockNum * blockSize +1;
		
		int pageCount = (int) Math.ceil(rowCount/(double)pageSize);
		System.out.println("pageCount@@@@"+pageCount);
		
		endPage = (pageCount < startPage + (blockSize-1))? pageCount : startPage + (blockSize-1) ;
		
		System.out.println("startPage@@@@"+startPage+"  endPage@@@@"+endPage);
		
		prevBlock = startPage - blockSize;
		nextBlock = startPage + blockSize;
		
		if(prevBlock < 0) {
			existPrev = false;
			existNext = true;
		}else{
			existPrev = true;
			existNext = false;
		}
		
		System.out.println("prevBlock@@@@"+prevBlock+"  nextBlock@@@@"+nextBlock);

	}

}
