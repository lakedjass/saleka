package com.saleka.application.security;

import com.saleka.application.blog.category.Category;
import com.saleka.application.blog.category.CategoryRepository;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.comment.CommentRepository;
import com.saleka.application.blog.post.Post;
import com.saleka.application.blog.post.PostRepository;
import com.saleka.application.blog.tag.Tag;
import com.saleka.application.blog.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        //Creation des permissions accepté sur l'application
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege= createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        Privilege deletePrivilege= createPrivilegeIfNotFound("DELETE_PRIVILEGE");

        //attribution des privilieges de base selon le role
        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege, deletePrivilege);
        List<Privilege> heroPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound("ADMIN", adminPrivileges);
        createRoleIfNotFound("HERO", heroPrivileges);
        createRoleIfNotFound("USER", Arrays.asList(readPrivilege));

        //récupération des roles pour créer quelques utilisateurs dans la bd utilisateurs
        Role adminRole = roleRepository.findByName("ADMIN");
        Role heroRole = roleRepository.findByName("HERO");
        Role userRole = roleRepository.findByName("USER");

        //Création des utiliasteurs avec chacun un role à des fins de test
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setFirstName("saleka");
        user1.setLastName("saleka");
        user1.setPassword(passwordEncoder.encode("admin"));
        user1.setEmail("admin@saleka.com");
        user1.setRoles(Arrays.asList(adminRole));
        user1.setEnabled(true);

        user2.setFirstName("user");
        user2.setLastName("user");
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setEmail("user@saleka.com");
        user2.setRoles(Arrays.asList(userRole));
        user2.setEnabled(true);

        user3.setFirstName("hero");
        user3.setLastName("hero");
        user3.setPassword(passwordEncoder.encode("hero"));
        user3.setEmail("hero@saleka.com");
        user3.setRoles(Arrays.asList(heroRole));
        user3.setEnabled(true);

        List<User> listUsers = new ArrayList<>();
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);


        userRepository.saveAll(listUsers);

        //Creation des tags de posts
        List<Tag> tags = new ArrayList<>();

        Tag ntic = new Tag();
        ntic.setKey("NTIC");
        tags.add(ntic);

        Tag business = new Tag();
        business.setKey("BUSINESS");
        tags.add(business);

        Tag mac = new Tag();
        mac.setKey("MAC");
        tags.add(mac);

        Tag design = new Tag();
        design.setKey("DESIGN");
        tags.add(design);

        Tag studio = new Tag();
        studio.setKey("STUDIO");
        tags.add(studio);

        Tag smart = new Tag();
        smart.setKey("SMART");
        tags.add(smart);

        Tag creative = new Tag();
        creative.setKey("CREATIVE");
        tags.add(creative);

        Tag tips = new Tag();
        tips.setKey("TIPS");
        tags.add(tips);

        Tag marketing = new Tag();
        marketing.setKey("MARKETING");
        tags.add(marketing);

        tagRepository.saveAll(tags);

        //Creation des categories de posts
        List<Category> categories = new ArrayList<>();

        Category covid = new Category();
        covid.setTitle("COVID 19");
        categories.add(covid);

        Category nba = new Category();
        nba.setTitle("NBA");
        categories.add(nba);

        Category meteo = new Category();
        meteo.setTitle("METEO");
        categories.add(meteo);

        Category foot = new Category();
        foot.setTitle("FOOTBALL");
        categories.add(foot);

        Category people = new Category();
        people.setTitle("PRESS PEOPLE");
        categories.add(people);

        Category tech = new Category();
        tech.setTitle("TECHNOLOGY");
        categories.add(tech);

        categoryRepository.saveAll(categories);

        //Creation des posts
        List<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setAuthor( user1 );
        post1.setCategories(categories.subList(1, 3));
        post1.setTags(tags.subList(0,7));
        post1.setBody("Le taux d’incidence semble se stabiliser, mais au-dessus du seuil d’alerte. La part du variant Delta est à interpréter avec prudence\n" +
                "Un ultimatum de sept jours. C’est le délai fixé par le Premier ministre Jean Castex avant de décider, ou non, la poursuite de restrictions dans les Landes, notamment sur la question des « jauges » dans les lieux recevant du public. Mais aucun critère chiffré n’a été avancé par le gouvernement.");
        post1.setTitle("Covid-19 et variant Delta dans les Landes : concrètement, où en est la situation ?");
        posts.add(post1);

        Post post2= new Post();
        post2.setAuthor( user2 );
        post2.setCategories(categories.subList(2,4));
        post2.setTags(tags.subList(0,8));
        post2.setBody("Plus que jamais déterminé à porter les Bucks en grande finale, Giannis Antetokounmpo n’est pas là pour plaisanter dans ces playoffs. Il l’a rappelé ce dimanche soir, avec un rapprochement sur un gros record appartenant à Shaquille O’Neal.\n" +
                "\n" +
                "Pour les Bucks, c’est sûrement l’année ou jamais pour tenter de remporter ce titre NBA. Avec l’élimination de la concurrence à l’Ouest, et celle des Nets à l’Est, la franchise du Wisconsin possède une voie royale pour tenter de remporter la bague, et ainsi donner raison à Giannis Antetokounmpo, qui a décidé de rester sur le long terme.\n" +
                "\n" +
                "Mais avant de penser au titre, il faut éliminer les Hawks, qui ne sont pas là pour faciliter la tâche de Milwaukee. La franchise a même remporté le premier match mais depuis, la mission s’est légèrement corsée. Il faut dire que Giannis ne rigole pas.\n" +
                "\n" +
                "Sûrement frustré d’avoir mal débuté cette finale de conférence, le Greek Freak s’est fâché. Il compile 33 points, 11 rebonds, 4 passes et 2 interceptions dans le succès des siens ce dimanche soir dans le Game 3 : 113-102. Voilà que les hommes de Mike Bundenholzer reprennent le contrôle, mais ils doivent aussi remercier Khris Middleton.\n" +
                "\n" + "Giannis Antetokounmpo a eu son 9ème match avec au moins 30 points et 10 rebonds dans cette postseason, le plus gros total depuis Shaquille O’Neal en 2000 (13).");
        post2.setTitle("NBA – Giannis tout proche de battre un record vieux de 21 ans appartenant au Shaq !");
        posts.add(post2);

        Post post3 = new Post();
        post3.setAuthor(user3);
        post3.setBody("nternet est tombé fou amoureux des jumelles « Trueblue » après que leur mère a partagé pour la première fois des photos de Megan et Morgan Boyd sur Instagram. Stephanie Boyd a commencé à publier des photos de ses jumelles à l’âge de quatre ans, les surnommant les jumelles « Trueblue ». La beauté unique des jumelles a attiré l’attention de plus de 166 000 utilisateurs d’Instagram. Leurs fans ne se lassent pas de ces deux jeunes beautés. Voici quelques-unes de leurs photos les plus populaires… continuez à lire pour voir à quoi elles ressemblent aujourd’hui !\n" +
                "\n" +
                "Les jumelles sont nées en juin 2011\n" +
                "Les jumelles Megan et Morgan Boyd sont nées le 6 juin 2011. Ce fut le coup de foudre pour leur mère, Stéphanie, et elle a immédiatement su qu’il y avait quelque chose de spécial chez ses filles. Les filles sont nées avec de beaux yeux qui ont envouté tous ceux qui croisaient leur regard. Stephanie était ravie d’accueillir les filles dans ce monde et savait qu’elle adorerait être la mère de Megan et Morgan.");
        post3.setTitle("Les Jumelles “Trueblue” Développent Un Nombre Impressionnant De Followers Sur Instagram");
        post3.setCategories(categories.subList(0,5));
        post3.setTags(tags.subList(1,8));
        posts.add(post3);

        Post post4 = new Post();
        post4.setAuthor(user1);
        post4.setCategories(categories.subList(0,3));
        post4.setTags(tags.subList(1, 6));
        post4.setTitle("FC BARCELONE - MERCATO : LE PSG A SIGNÉ UN DERNIER COUP DE MAÎTRE MAGISTRAL AVEC MESSI !\n");
        post4.setBody("Messi enchanté de l'arrivée de Wijnaldum\n" +
                "Le dirigeant brésilien savait en effet que Messi avait donné son feu vert avec un grand optimisme pour son arrivée au FC Barcelone. Attirer au PSG le milieu international néerlandais était donc à ses yeux un argument solide de plus pour aimanter « La Pulga » dans la Ville Lumière.\n" +
                "\n" +
                "« Messi était enchanté à l’idée que le Barça boucle son arrivée, a assuré récemment son agent Humphry Nijman dans l’émission « Here we go » relayée en Espagne. Gini, lui, était alors fier de pouvoir compter sur son soutien. » Le PSG et Leonardo sont passés par là entre temps...\n" +
                "\n");
        posts.add(post4);

        Post post5 = new Post();
        post5.setAuthor(user2);
        post5.setCategories(categories.subList(1,5));
        post5.setTags(tags.subList(2,8));
        post5.setTitle("Orages, grêle, vent : 11 départements en vigilance orange");
        post5.setBody("\"Une nouvelle vague orageuse attendue en début d'après-midi\"\n" +
                "Selon le bulletin de Météo France publié à 10h, \"ce (lundi) matin la situation est assez calme dans la zone en vigilance orange. Quelques orages faibles et sporadiques s'y sont produits. L'événement n'a pas encore débuté\".\n" +
                "\n" +
                "\"Une nouvelle vague orageuse est attendue dès le début d'après-midi au nord-est du Massif Central. Les orages se propageront rapidement vers le nord. Près des frontières suisses et allemandes jusqu’en milieu de nuit, il existe un risque d'orages violents avec des chutes de grêle, de fortes rafales de vent (voisines de 100 km/h) et de fortes intensités de précipitations (de l'ordre de 30 mm/h). L'activité orageuse diminuera nettement au cours de la nuit de lundi à mardi. La vigilance orange pourra alors être levée\".");
        posts.add(post5);

        Post post6 = new Post();
        post6.setAuthor(user3);
        post6.setCategories(categories.subList(2,5));
        post6.setTags(tags.subList(0,5));
        post6.setBody("Microsoft exclut donc pas mal systèmes basés sur des processeurs un peu anciens.\n" +
                "\n" +
                "Lorsque Microsoft a présenté officiellement Windows 11, la firme a indiqué que l’un des critères d’éligibilité au nouvel OS était la technologie TPM (Trusted Platform Module) 2.0. Malheureusement, ce prérequis risque bien d’exclure bon nombre de PC DIY actuellement utilisés. En effet, dans la liste des CPU pris en charge par Microsoft, ne figurent pas les Ryzen 1xxx ainsi que les Intel Core sortis avant ceux de 8e génération (Coffee Lake).");
        post6.setTitle("Windows 11 nécessitera au moins un processeur Intel Core de 8e génération ou AMD Ryzen de 2e génération");
        posts.add(post6);

        //Creation des Comments
        List<Comment> comments = new ArrayList<>();

        Comment comment1 = new Comment();
        comment1.setAuthor(user2);
        comment1.setBody("Giannis is on fire - The Greak has to be great");
        comment1.setPost(post2);
        comments.add(comment1);

        Comment comment2 = new Comment();
        comment2.setAuthor(user1);
        comment2.setBody("C'est une opportunité et une belle .Oui il ne vient pas pour des cacahuètes. Mais niveau transfert il est gratuit.");
        comment2.setPost(post4);
        comments.add(comment2);

        Comment comment3 = new Comment();
        comment3.setAuthor(user1);
        comment3.setBody("Avec Windows 11, Microsoft s'agrege a l'ecosysteme Android");
        comment3.setPost(post4);
        comments.add(comment3);

        postRepository.saveAll(posts);
        commentRepository.saveAll(comments);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}