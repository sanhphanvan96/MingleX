<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Chat">
    <div class="flex-container" style="padding-top: 53px;">

        <!-- Navbar -->
        <jsp:include page="/WEB-INF/components/navbar.jsp" >
            <jsp:param name="active" value="Chat"/>
        </jsp:include>

        <%--Chatroom Sidebar--%>
        <div class="sidebar alice-blue w3-bar-block">
            <div class="chatroom-sidebar">
                <a class="chat-item active" href="#1">
                    Alice
                </a>
                <a class="chat-item" href="#2">
                    Bob
                </a>
                <a class="chat-item" href="#3">
                    Clever
                </a>
                <a class="chat-item" href="#4">
                    Developer
                </a>
            </div>
        </div>
    </div>

    <!-- Chatroom Content -->
    <div class="container chat with-sidebar">
        <div id="chatroom" class="hidden">
            <div class="message left">
                <p><span>Hi there!</span></p>
            </div>

            <div class="message right">
                <p><span>Hi there!</span></p>
            </div>

            <div class="message left">
                <p><span>Hi there!</span></p>
            </div>
        </div>
        <div id="invite-message" class="hidden">
            <p>You haven't chatted yet. Do you want to connect with Alice?</p>
            <form action="/">
                <input type="submit" id="invite" class="btn btn-primary" value="Mingle">
            </form>
        </div>
        <div id="accept-message" class="hidden">
            <p>Peter wants to connect with you.</p>
            <form action="/">
                <input type="submit" id="accept" class="btn btn-primary" value="Ready to mingle!">
            </form>
        </div>
        <div id="wait-message" class="hidden">
            <p>You sent an invite to Alice. Waiting for Alice's response...</p>
        </div>
        <div id="connect-message" class="hidden">
            <p>Alice has accepted your invite.</p>
            <form action="/">
                <input type="submit" id="connect" class="btn btn-primary" value="OK">
            </form>
        </div>
        <div class="chatbox">
            <form action="/" method="POST">
                <div class="form-group row">
                    <div class="col-md-11 field">
                        <textarea rows="2"
                                  placeholder="Type a message..."
                                  id="chatbox"
                                  class="form-control"></textarea>
                    </div>

                    <div class="col-md-1 field">
                        <input type="submit" id="sendMessage" class="btn btn-primary" value="Send">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script>
        // when user click on sidebar link
        $(".chatroom-sidebar a").on("click", function() {
            // set active for this element (link of user is chatting with)
            $(".chatroom-sidebar a").each(function() {
                $(this).removeClass("active");
            })
            if(!$(this).hasClass("active")) {
                $(this).addClass("active");
            }

            // reset state of message box
            $(".chat div").each(function() {
                if (!$(this).hasClass("hidden")) {
                    $(this).addClass("hidden");                                
                }
            })

            var user_id = this.href.split("#")[1];
            console.log({"user_id": user_id});
            $.ajax({
                url: "http://localhost:1234/chat",
                method: "POST",
                data: {
                    user_id: user_id
                },
                success: function(res) {
                        console.log(res);
                        handleResponse(res);
                }
            })
        })
        function handleResponse(res) {
            console.log({handleResponse: res.status});
            switch (res.status) {
                case "waiting":
                    $("#wait-message").removeClass("hidden");
                    break;
                case "invited":
                    $("#accept-message").removeClass("hidden");
                    break;
                case "accepted":
                    $("#connect-message").removeClass("hidden")
                    break;
                case "unconnected":
                    $("#invite-message").removeClass("hidden");
                    break;
                case "connected":
                    $("#chatroom").removeClass("hidden");
                    viewMessage(res);
                    break;
                default:
                    break;
            }
        }
        function viewMessage(res) {

            // remove old messages
            $("#chatroom").empty();

            var sender = res.user_id;
            var messages = res.message; // message array

            messages.forEach(message => {
                console.log(message)
                // if message is of current user, show in left side
                // if message is of another user, show in right side
                if(message.sender == sender) {
                    var msgElement = `<div class="message right">` +
                                    `<p><span>` + message.content +
                                    `</span></p></div>`;
                } else {
                    var msgElement = `<div class="message left">` +
                                    `<p><span>` + message.content +
                                    `</span></p></div>`;
                }
                $("#chatroom").append(msgElement);
            });
        }
    </script>
</t:wrapper>