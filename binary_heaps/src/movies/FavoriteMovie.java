package movies;

public class FavoriteMovie implements Comparable<FavoriteMovie>
{
    private int stars;
    private String name;

    public FavoriteMovie(int stars, String name)
    {
        this.stars = stars;
        this.name = name;
    }

    @Override
    public int compareTo(FavoriteMovie other)
    {
        return name.compareTo(other.name);
    }

    public int getStars()
    {
        return stars;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "movies.FavoriteMovie{" +
                "stars=" + stars +
                ", name='" + name + '\'' +
                '}';
    }
}
