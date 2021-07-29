(function() {
    const photo = document.querySelector("#userProfilePhoto")
    let photoDialog = document.querySelector("#userProfileBloc")
    handleShowDialogButton(photo, photoDialog)

    const emailCorpEditButton = document.querySelector("#salekaTopBarEmail")
    const emailCorpDialog = document.querySelector("#salekaTopbarEmailDiv")
    handleShowDialogButton(emailCorpEditButton, emailCorpDialog)

    const sloganCorpEditButton = document.querySelector("#salekaTopbarSlogan")
    const sloganCorpDialog = document.querySelector("#salekaTopbarSloganDiv")
    handleShowDialogButton(sloganCorpEditButton, sloganCorpDialog)

    const telCorpEditButton = document.querySelector("#salekaTopbarTel")
    const telDialog = document.querySelector("#salekaTopbarTelDiv")
    handleShowDialogButton(telCorpEditButton, telDialog)

    const heroTitreEditButton = document.querySelector("#salekaHeroTitre")
    const heroTitreDialog = document.querySelector("#salekaHeroTitreDiv")
    handleShowDialogButton(heroTitreEditButton, heroTitreDialog)

    const heroSousTitreEditButton = document.querySelector("#salekaHeroSousTitre")
    const heroSousTitreDialog = document.querySelector("#salekaHeroSousTitreDiv")
    handleShowDialogButton(heroSousTitreEditButton, heroSousTitreDialog)

    const bloc1WhyusTitreEditButton = document.querySelector("#salekaBloc1WhyusTitre")
    const bloc1WhyusTitreDialog = document.querySelector("#salekaBloc1WhyusTitreDiv")
    handleShowDialogButton(bloc1WhyusTitreEditButton,bloc1WhyusTitreDialog)

    const bloc1WhyusSousTitreEditButton = document.querySelector("#salekaBloc1WhyusSousTitre")
    const bloc1WhyusSousTitreDialog = document.querySelector("#salekaBloc1WhyusSousTitreDiv")
    handleShowDialogButton(bloc1WhyusSousTitreEditButton,bloc1WhyusSousTitreDialog)


    const salekaBloc2WhyusBoite1TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite1Titre")
    const salekaBloc2WhyusBoite1TitreDialog = document.querySelector("#salekaBloc2WhyusBoite1TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite1TitreEditButton,salekaBloc2WhyusBoite1TitreDialog)
    const salekaBloc2WhyusBoite1SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite1SousTitre")
    const salekaBloc2WhyusBoite1SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite1SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite1SousTitreEditButton,salekaBloc2WhyusBoite1SousTitreDialog)
    const salekaBloc2WhyusBoite2TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite2Titre")
    const salekaBloc2WhyusBoite2TitreDialog = document.querySelector("#salekaBloc2WhyusBoite2TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite2TitreEditButton,salekaBloc2WhyusBoite2TitreDialog)
    const salekaBloc2WhyusBoite2SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite2SousTitre")
    const salekaBloc2WhyusBoite2SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite2SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite2SousTitreEditButton,salekaBloc2WhyusBoite2SousTitreDialog)
    const salekaBloc2WhyusBoite3TitreEditButton = document.querySelector("#salekaBloc2WhyusBoite3Titre")
    const salekaBloc2WhyusBoite3TitreDialog = document.querySelector("#salekaBloc2WhyusBoite3TitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite3TitreEditButton,salekaBloc2WhyusBoite3TitreDialog)
    const salekaBloc2WhyusBoite3SousTitreEditButton = document.querySelector("#salekaBloc2WhyusBoite3SousTitre")
    const salekaBloc2WhyusBoite3SousTitreDialog = document.querySelector("#salekaBloc2WhyusBoite3SousTitreDiv")
    handleShowDialogButton(salekaBloc2WhyusBoite3SousTitreEditButton,salekaBloc2WhyusBoite3SousTitreDialog)

})();

function handleShowDialogButton(btnElement, dialogBox){
    if (dialogBox){
        let cancelButton = dialogBox.querySelector('.cancel')
        if (btnElement){
            btnElement.addEventListener('click', (event) => {
                event.preventDefault()
                console.log(btnElement,dialogBox)
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
