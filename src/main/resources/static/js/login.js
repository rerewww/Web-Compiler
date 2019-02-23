var loginManager = {
    guestLogin: function () {
        $.ajax({
            url: '/main',
            type:'POST',
            data: {
                userId: "guest",
                userName: "guest",
                isGuest: true
            }
        });
    }
};
