var loginManager = {
    guestLogin: function () {
        $.ajax({
            url: '/main',
            type:'POST',
            data: {
                userId: "guest"
            }
        });
    }
};
