package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.service.WriteService;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Controller
public class WriteController {
	
	@Autowired(required = false)
	private WriteService ws;

	//리뷰작성완료
	@RequestMapping(value = "review_write.do", method=POST)
	public String reviewWrite(HttpServletRequest request, HttpSession session) {
		
		int restarea_idx=Integer.parseInt(request.getParameter("restarea_idx"));
		String url="redirect:user_detailed.do?restarea_idx="+restarea_idx;
			
		if(session.getAttribute("id")==null) {
			url="forward:user_mainhome.do"; 
		}else {
			int len=Integer.parseInt(request.getParameter("imglen"));
			
			WriteReviewVO wrVO=new WriteReviewVO();
			wrVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
			wrVO.setId(request.getParameter("id"));
			wrVO.setRating(Integer.parseInt(request.getParameter("rating")));
			wrVO.setContents(request.getParameter("contents"));
			
			ws.setReview(wrVO);
			
			int reviewIdx=ws.searchNewIdx(restarea_idx);
			
			WriteReviewImgVO wriVO=new WriteReviewImgVO();
			
			if (len!=0) {
				for(int i=0; i<len; i++) {
					wriVO.setId(request.getParameter("id"));
					wriVO.setReview_idx(reviewIdx);
					wriVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
					wriVO.setImg_idx(i+1);
					
					String imgname=request.getParameter("img-"+i);
					if(imgname.contains(".pnget")) {
						imgname=imgname.replaceAll(".pnget", "");
					}
					
					wriVO.setImg(imgname);
					ws.setReviewImg(wriVO);
				}
			}
		}
		
		return url;
	}
	
	//이미지 업로드 구현 (비동기)
	@ResponseBody
	@RequestMapping(value = "ajax_img_upload.do", method=POST)
	public void enterLike(HttpServletRequest request) {
		File saveDir = new File("/home/ubuntu/potato_mvc/css/reviewImg/");
		int maxSize=1024*1024*20;
		try {
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//리뷰 수정 작성완료
	@RequestMapping(value = "re_review_write.do", method={GET,POST})
	public String reReviewWrite(HttpServletRequest request, HttpSession session) {
		
		int restarea_idx=Integer.parseInt(request.getParameter("restarea_idx"));
		String url="redirect:user_detailed.do?restarea_idx="+restarea_idx;
			
		if(session.getAttribute("id")==null) {
			url="forward:user_mainhome.do"; 
		}else {
			int len=Integer.parseInt(request.getParameter("imglen"));
			
			WriteReviewVO wrVO=new WriteReviewVO();
			
			wrVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
			wrVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
			wrVO.setId(request.getParameter("id"));
			wrVO.setRating(Integer.parseInt(request.getParameter("rating")));
			wrVO.setContents(request.getParameter("contents"));
			
			ws.setReReview(wrVO);
			
			ws.delReReviewImg(wrVO);
			
			WriteReviewImgVO wriVO=new WriteReviewImgVO();
			 
			if (len!=0) {
				for(int i=0; i<len; i++) {
					System.out.println("find me: "+request.getParameter("img-"+i));
					wriVO.setId(request.getParameter("id"));
					wriVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
					wriVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
					wriVO.setImg_idx(i+1);
					
					String imgname=request.getParameter("img-"+i);
					if(imgname.contains(".pnget")) {
						imgname=imgname.replaceAll(".pnget", "");
					}
					
					wriVO.setImg(imgname);
					ws.setReviewImg(wriVO);
				}
			}
		}
		
		return url;
	}
	
	/*
	//이미지 삭제
	@ResponseBody
	@RequestMapping(value = "ajax_img_delete.do", method=POST)
	public void deleteImg(HttpServletRequest request) {
		File file=new File("","");
		file.delete();
	}*/
	
}
