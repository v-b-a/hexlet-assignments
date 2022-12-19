package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping("/{postId}/comments")
    public Iterable<Comment> getCommentsByPostId(@PathVariable(name = "postId") Long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public Comment getCommentByPostIdAndCommentId(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "commentId") Long commentId
    ) {
        if (commentRepository.findCommentByIdAndPostId(commentId, postId) == null) {
            throw new ResourceNotFoundException("Post not found");
        }
        return commentRepository.findCommentByIdAndPostId(commentId, postId);
    }
    @PostMapping("/{postId}/comments")
    public Iterable<Comment> createCommentByPostId(
            @PathVariable(name = "postId") Long postId,
            @RequestBody Comment comment) {
        Comment newComment = new Comment();
        comment.setPost(postRepository.findById(postId).get());
        commentRepository.save(comment);
        return commentRepository.findCommentsByPostId(postId);
    }
    @PatchMapping("/{postId}/comments/{commentId}")
    public Comment updateCommentByPostIdAndCommentId(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "commentId") Long commentId,
            @RequestBody Comment comment
    ) {
        if (commentRepository.findCommentByIdAndPostId(commentId, postId) == null) {
            throw new ResourceNotFoundException("Post not found");
        }
        Comment newComment = commentRepository.findById(commentId).get();
        newComment.setContent(comment.getContent());
//        newComment.setPost(comment.getPost());
        commentRepository.save(newComment);
        return newComment;
    }
    @DeleteMapping("/{postId}/comments/{commentId}")
    public void deleteCommentByPostIdAndCommentId(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "commentId") Long commentId
    ) {
        if (commentRepository.findCommentByIdAndPostId(commentId, postId) == null) {
            throw new ResourceNotFoundException("Post not found");
        }
        commentRepository.deleteById(commentId);
//        postRepository.dele
//        return newComment;
    }
    // END
}
