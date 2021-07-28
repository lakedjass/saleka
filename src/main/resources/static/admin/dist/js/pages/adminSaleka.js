(function() {
    const photo = document.querySelector("#userProfilePhoto")
    let photoDialog = document.querySelector("#userProfileBloc")
    handleShowDialogButton(photo, photoDialog)

    const emailCorpEditButton = document.querySelector("#salekaTopbarEmail")
    const EmailDialog = document.querySelector("#salekaTopbarEmailDiv")
    handleShowDialogButton(emailCorpEditButton, EmailDialog)

    const sloganCorpEditButton = document.querySelector("#salekaTopbarSlogan")
    const sloganDialog = document.querySelector("#salekaTopbarSloganDiv")
    handleShowDialogButton(sloganCorpEditButton, sloganDialog)

    const telCorpEditButton = document.querySelector("#salekaTopbarTel")
    const telDialog = document.querySelector("#salekaTopbarTelDiv")
    handleShowDialogButton(telCorpEditButton, telDialog)

    const heroTitreEditButton = document.querySelector("#salekaHeroTitre")
    const heroTitreDialog = document.querySelector("#salekaHeroTitreDiv")
    handleShowDialogButton(heroTitreEditButton, heroTitreDialog)

    const heroSousTitreEditButton = document.querySelector("#salekaHeroSousTitre")
    const heroSousTitreDialog = document.querySelector("#salekaHeroSousTitreDiv")
    handleShowDialogButton(heroSousTitreEditButton, heroSousTitreDialog)

})();

function handleShowDialogButton(btnElement, dialogBox){
    if (dialogBox){
        let cancelButton = dialogBox.querySelector('.cancel')
        if (btnElement){
            btnElement.addEventListener('click', (event) => {
                event.preventDefault()
                $(dialogBox).toggle();
            })}
        if (cancelButton){
            cancelButton.addEventListener('click', evt => {
                evt.preventDefault()
                console.log("j'ai cliqué sur annuler")
                $(dialogBox).toggle();
            })
        }
    }

}


(function() {
    const setImageAsDefaultButton = document.querySelector("#setBackgroundHome")
    if (setImageAsDefaultButton){
        setImageAsDefaultButton.addEventListener('click', evt => {
            evt.preventDefault()
            console.log('clique definir')
        })
    }

})();

(function() {
    const backgroundBlock = document.querySelector("#hero")
    const newImageHome = backgroundBlock.getAttribute(value)
    console.log(newImageHome)
    if (backgroundBlock){
        backgroundBlock.style.background = `url('/media/images/'+ ${newImageHome}) center center`;
    }

})();



$(document).on('change', '.file-input', function() {


    var filesCount = $(this)[0].files.length;

    var textbox = $(this).prev();

    if (filesCount === 1) {
        var fileName = $(this).val().split('\\').pop();
        textbox.text(fileName);
    } else {
        textbox.text(filesCount + ' files selected');
    }

    if (typeof (FileReader) != "undefined") {
        var dvPreview = $("#divImageMediaPreview");
        dvPreview.html("");
        $($(this)[0].files).each(function () {
            var file = $(this);
            var reader = new FileReader();
            reader.onload = function (e) {
                var img = $("<img />");
                img.attr("style", "width: 150px; height:100px; padding: 10px");
                img.attr("src", e.target.result);
                dvPreview.append(img);
            }
            reader.readAsDataURL(file[0]);
        });
    } else {
        alert("This browser does not support HTML5 FileReader.");
    }


});
