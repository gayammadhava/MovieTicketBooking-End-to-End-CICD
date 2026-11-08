
document.addEventListener("DOMContentLoaded", function () {

    const ticketInputs = document.querySelectorAll(
        'input[name="tickets"]'
    );

    ticketInputs.forEach(function (input) {

        input.addEventListener("change", function () {

            let value = parseInt(input.value, 10);

            if (isNaN(value) || value < 1) {
                input.value = 1;
            } else if (value > 10) {
                input.value = 10;
            }

        });

    });

});
